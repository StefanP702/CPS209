import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FlightManager 
{
    // Contains list of Flights departing from Toronto in a single day
    TreeMap<String, Flight> flights;
    HashSet<CrewMember> crews = new HashSet<>();

    String[] cities = {"Dallas", "New York", "London", "Paris", "Tokyo"};

    // flight times in hours
    int[] flightTimes = {3, // Dallas
            1, // New York
            7, // London
            8, // Paris
            16// Tokyo
        };

    // Contains list of available airplane types and their seat capacity
    ArrayList<Aircraft> airplanes = new ArrayList<>();

    Random random = new Random(); // random number generator - google "Java class Random". Use this in generateFlightNumber

    public FlightManager() throws FileNotFoundException 
    {
        flights = new TreeMap<>();

        // Create some aircraft types with max seat capacities
        airplanes.add(new Aircraft(85, "Boeing 737"));
        airplanes.add(new Aircraft(180, "Airbus 320"));
        airplanes.add(new Aircraft(37, "Dash-8 100"));
        airplanes.add(new Aircraft(12, "Bombardier 5000"));
        airplanes.add(new Aircraft(592, 14, "Boeing 747"));

        crews.add(new CrewMember("Jack", CrewTitle.PILOT));
        crews.add(new CrewMember("Tom", CrewTitle.PILOT));
        crews.add(new CrewMember("Black", CrewTitle.NAVIGATOR));
        crews.add(new CrewMember("Billy", CrewTitle.NAVIGATOR));
        crews.add(new CrewMember("Rony", CrewTitle.NAVIGATOR));
        crews.add(new CrewMember("Jane", CrewTitle.ATTENDANT));
        crews.add(new CrewMember("Lisa", CrewTitle.ATTENDANT));
        crews.add(new CrewMember("Elsa", CrewTitle.ATTENDANT));
        crews.add(new CrewMember("Belly", CrewTitle.ATTENDANT));

        Scanner sc = new Scanner(new File("flights.txt"));
        while (sc.hasNext()) 
        {
            String airline = sc.next();
            airline = airline.replace("_", " ");
            String dest = sc.next();
            dest = dest.replace("_", " ");
            String depart = sc.next();
            int seats = sc.nextInt();

            String fNum = generateFlightNumber(airline);
            int ft_id = -1;
            for (int i = 0; i < cities.length; i++)
            {
                if (cities[i].equals(dest))
                {
                    ft_id = i; 
                }
            }
            if (ft_id > -1) 
            {
                Aircraft aircraft;
                Flight flight;
                if (seats > 85) 
                {
                    aircraft = new Aircraft(seats, 12, "Boeing 747");
                    flight = new LongHaulFlight(fNum, airline, dest, depart, flightTimes[ft_id], aircraft);
                } 
                else 
                {
                    aircraft = new Aircraft(seats, "Boeing 737");
                    flight = new Flight(fNum, airline, dest, depart, flightTimes[ft_id], aircraft);
                }
                flights.put(fNum, flight);
            }
        }
        sc.close();
    }

    /*
     * This private helper method generates and returns a flight number string from the airline name parameter
     * For example, if parameter string airline is "Air Canada" the flight number should be "ACxxx" where xxx is
     * a random 3 digit number between 101 and 300 (Hint: use class Random - see variable random at top of class)
     * you can assume every airline name is always 2 words.
     *
     */
    private String generateFlightNumber(String airline) 
    {
        int min = 101; 
        int max = 300;
        String flightNumber = "";
        int numVal;// value of flight number
        numVal = random.nextInt(max - min) + min;
        if(airline.equalsIgnoreCase("Air Canada"))
        {
            flightNumber = "AC" + numVal; 

        }
        else if(airline.equalsIgnoreCase("United Airlines"))
        {
            flightNumber = "UA" + numVal; 

        }
        else if(airline.equalsIgnoreCase("Porter Airlines"))
        {
            flightNumber = "PA" + numVal; 

        }
        return flightNumber; 
    }

    
    public void printAllFlights() 
    {
        for (Map.Entry<String, Flight> e : flights.entrySet()) 
        {
            System.out.println(e.getValue());
        }
    }

    /*
     * Given a Reservation object, cancel the seat on the flight
     */
    public void cancelReservation(Reservation res) throws FlightNotFoundException, PassengerNotInManifestException 
    {

        Flight flight = flights.get(res.getFlightNum());
        if (flight == null)
        {
            throw new FlightNotFoundException(res.getFlightNum()); 
        }

        if (flight.getFlightNum().equals(res.getFlightNum())) 
        {
            flight.cancelSeat(new Passenger(res.getPassengerName(),res.getPassengerPassport(),res.getSeat(),res.isFirstClass()? LongHaulFlight.firstClass : LongHaulFlight.economy));
        }

    }

    public Reservation reserveSeatOnFlight(String flightNum, String name, String passport, String seat) throws FlightNotFoundException, DuplicatePassengerException, SeatOccupiedException 
    {
        Flight flight = flights.get(flightNum);
        if (flight == null)
        {
            throw new FlightNotFoundException(flightNum); 
        }
        Passenger passenger = new Passenger(name, passport, seat, seat.charAt(0) == '+' ? LongHaulFlight.firstClass : LongHaulFlight.economy);
        flight.reserveSeat(passenger, seat);
        return new Reservation(flightNum, flight.toString(), passenger);
    }

    public void printAllPassengers(String flightNum) throws FlightNotFoundException 
    {
        Flight flight = flights.get(flightNum);
        if (flight == null) 
        {
            throw new FlightNotFoundException(flightNum);
        }
        flight.printPassengerManifest();
    }

    public void printSeats(String flightNum) throws FlightNotFoundException 
    {
        Flight flight = flights.get(flightNum);
        if (flight == null)
        {
            throw new FlightNotFoundException(flightNum); 
        }
        flight.printSeats();
    }

    public void createPreboardQueue(String flightNum) throws FlightNotFoundException 
    {
        Flight flight = flights.get(flightNum);
        if (flight == null)
        {
            throw new FlightNotFoundException(flightNum); 
        }
        flight.createPreboardQueue();
    }

    public void printQueue(String flightNum) throws FlightNotFoundException
    {
        Flight flight = flights.get(flightNum);
        if (flight == null)
        {
            throw new FlightNotFoundException(flightNum); 
        }
        flight.printQueue();
    }

    public void boardQueue(String flightNum, int startRow, int endRow) throws FlightNotFoundException 
    {
        Flight flight = flights.get(flightNum);
        if (flight == null)
        {
            throw new FlightNotFoundException(flightNum); 
        }
        flight.board(startRow, endRow);
    }

    public void addCrew(String flightNum, CrewMember member) throws FlightNotFoundException, DuplicateCrewException, CrewOccupiedException 
    {
        Flight flight = flights.get(flightNum);
        if (flight == null)
        {
            throw new FlightNotFoundException(flightNum); 
        }

        for (Map.Entry<String, Flight> entry : flights.entrySet()) 
        {
            Flight f = entry.getValue();
            if (f.containsCrew(member))
            {
                throw new CrewOccupiedException(member); 
            }
        }
        crews.remove(member);
        flight.addCrew(member);
    }

    public void removeCrew(String flightNum, CrewMember member) throws FlightNotFoundException, CrewNotInFlightException 
    {
        Flight flight = flights.get(flightNum);
        if (flight == null)
        {
            throw new FlightNotFoundException(flightNum); 
        }
        flight.removeCrew(member);
        crews.add(member);
    }

    public void printCrews() 
    {
        for (CrewMember c : crews)
        {
            c.print(); 
        }
    }

    public void printCrews(String flightNum) throws FlightNotFoundException 
    {
        Flight flight = flights.get(flightNum);
        if (flight == null)
        {
            throw new FlightNotFoundException(flightNum); 
        }
        flight.printCrews();
    }
}
