import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class FlightManager 
{
    // Contains list of Flights departing from Toronto in a single day
    ArrayList<Flight> flights = new ArrayList<Flight>();

    String[] cities = {"Dallas", "New York", "London", "Paris", "Tokyo"};
    final int DALLAS = 0;
    final int NEWYORK = 1;
    final int LONDON = 2;
    final int PARIS = 3;
    final int TOKYO = 4;

    // flight times in hours
    int[] flightTimes = {3, // Dallas
            1, // New York
            7, // London
            8, // Paris
            16// Tokyo
        };

    // Contains list of available airplane types and their seat capacity
    ArrayList<Aircraft> airplanes = new ArrayList<Aircraft>();

    String errorMsg = null; // if a method finds an error (e.g. flight number not found) set this string. See video!

    Random random = new Random(); // random number generator - google "Java class Random". Use this in generateFlightNumber

    public FlightManager() 
    {
        // DO NOT ALTER THIS CODE - THE TA'S WILL USE IT TO TEST YOUR PROGRAM
        // IN ASSIGNMENT 2 YOU WILL BE LOADING THIS INFORMATION FROM A FILE

        // Create some aircraft types with max seat capacities
        airplanes.add(new Aircraft(85, "Boeing 737"));
        airplanes.add(new Aircraft(180, "Airbus 320"));
        airplanes.add(new Aircraft(37, "Dash-8 100"));
        airplanes.add(new Aircraft(12, "Bombardier 5000"));
        airplanes.add(new Aircraft(592, 14, "Boeing 747"));

        // Populate the list of flights with some random test flights
        String flightNum = generateFlightNumber("United Airlines");
        Flight flight = new Flight(flightNum, "United Airlines", "Dallas", "1400", flightTimes[DALLAS], airplanes.get(0));
        flights.add(flight);
        flight.setStatus(Flight.Status.DELAYED);

        flightNum = generateFlightNumber("Air Canada");
        flight = new Flight(flightNum, "Air Canada", "London", "2300", flightTimes[LONDON], airplanes.get(1));
        flights.add(flight);

        flightNum = generateFlightNumber("Air Canada");
        flight = new Flight(flightNum, "Air Canada", "Paris", "2200", flightTimes[PARIS], airplanes.get(1));
        flights.add(flight);

        flightNum = generateFlightNumber("Porter Airlines");
        flight = new Flight(flightNum, "Porter Airlines", "New York", "1200", flightTimes[NEWYORK], airplanes.get(2));
        flights.add(flight);

        flightNum = generateFlightNumber("United Airlines");
        flight = new Flight(flightNum, "United Airlines", "New York", "0900", flightTimes[NEWYORK], airplanes.get(3));
        flights.add(flight);
        flight.setStatus(Flight.Status.INFLIGHT);

        flightNum = generateFlightNumber("Air Canada");
        flight = new Flight(flightNum, "Air Canada", "New York", "0600", flightTimes[NEWYORK], airplanes.get(2));
        flights.add(flight);
        flight.setStatus(Flight.Status.INFLIGHT);

        flightNum = generateFlightNumber("United Airlines");
        flight = new Flight(flightNum, "United Airlines", "Paris", "2330", flightTimes[PARIS], airplanes.get(0));
        flights.add(flight);

        /*
         * Add this code back in when you are ready to tackle class LongHaulFlight and have implemented its methods
         */
        flightNum = generateFlightNumber("Air Canada");
        flight = new LongHaulFlight(flightNum, "Air Canada", "Tokyo", "2200", flightTimes[TOKYO], airplanes.get(4));
        flights.add(flight);
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

    // Prints all flights in flights array list (see class Flight toString() method)
    // This one is done for you!
    public void printAllFlights() 
    {
        for (int i = 0; i < flights.size(); i++) {
            System.out.println(flights.get(i).toString());
        }
    }

    // Given a flight number (e.g. "UA220"), check to see if there are economy seats available
    // if so return true, if not return false
    public boolean seatsAvailable(String flightNum) throws FlightFullException, FlightNotFoundException 
    {
        for (Flight flight : flights) 
        {
            if (flight.getFlightNum().equals(flightNum)) 
            {
                if (flight.seatsAvailable())
                {
                    return true; 
                }
                throw new FlightFullException(flightNum);
            }
        }
        throw new FlightNotFoundException(flightNum);
    }

   public Reservation reserveSeatOnFlight(String flightNum, String seatType) throws FlightFullException, FlightNotFoundException {
        // Check for valid flight number by searching through flights array list
        // If matching flight is not found, set instance variable errorMsg (see at top) and return null
        Flight flight = null;
        for (Flight f : flights)
        {
            if (f.getFlightNum().equals(flightNum))
            {  if (f.seatsAvailable()) 
                {
                    flight = f; 
                }
            }
        }         

        if (flight == null) 
        {
            throw new FlightNotFoundException(flightNum);
        }

        if (seatType.equals(LongHaulFlight.firstClass) && (flight instanceof LongHaulFlight)) 
        {
            LongHaulFlight lflight = (LongHaulFlight) flight;
            if (lflight.numFirstClassPassengers < lflight.aircraft.getNumFirstClassSeats()) 
            {
                lflight.reserveSeat(seatType);
                Reservation reservation = new Reservation(flightNum, lflight.toString() + "\n\t\tFCL");
                reservation.setFirstClass();
                return reservation;
            } 
            else 
            {
                throw new FlightFullException(flightNum);
            }
        } 
        else if(seatType.equals(LongHaulFlight.economy)) 
        {
            if (flight.seatsAvailable()) 
            {
                flight.reserveSeat();
                return new Reservation(flightNum, flight.toString());
            } 
            else 
            {
                throw new FlightFullException(flightNum);
            }
        }
        return null;
    }

    public String getErrorMessage() 
    {
        return errorMsg;
    }

    /*
     * Given a Reservation object, cancel the seat on the flight
     */
    public boolean cancelReservation(Reservation res) 
    {
        for (Flight f : flights) 
        {
            if (f.getFlightNum().equals(res.getFlightNum())) 
            {
                f.cancelSeat();
                if (res.getPassenger() != null)
                {
                    for (Passenger p : f.passengerList)
                    {
                        if (p.equals(res.getPassenger())) 
                        {
                            f.passengerList.remove(p);
                            break;
                        } 
                    }
                }
            }
        }
        return true; // remove this when you have written the code above
    }

    // Sort the array list of flights by increasing departure time
    // Essentially one line of code but you will be making use of a Comparator object below
    public void sortByDeparture() 
    {
        flights.sort(new DepartureTimeComparator());
    }
    
    public Reservation reserveSeatOnFlight(String flightNum, String name, String passport, String seatType) throws FlightFullException, FlightNotFoundException 
    {
        // Check for valid flight number by searching through flights array list
        // If matching flight is not found, set instance variable errorMsg (see at top) and return null
        Flight flight = null;
        for (Flight f : flights)
        {
            if (f.getFlightNum().equals(flightNum))
            {
                if (f.seatsAvailable())
                {
                    flight = f;
                } 
            }
        }

        if (flight == null) 
        {
            throw new FlightNotFoundException(flightNum);
        }

        if (seatType.equals(LongHaulFlight.economy)) 
        {
            if (flight.seatsAvailable()) 
            {
                if (flight.reserveSeat(name, passport)) 
                {
                    return new Reservation(flightNum, flight.toString(), flight.getLastPassenger());
                }
                errorMsg = "Same passenger in the flight reservation list";
            } 
            else 
            {
                throw new FlightFullException(flightNum);
            }
            return null;
        }
        return null; 
    }

    public void printAllPassengers(String flightNum) throws FlightNotFoundException 
    {
        Flight flight = null;
        for (Flight f : flights)
        {  if (f.getFlightNum().equals(flightNum))
            {
                if (f.seatsAvailable())
                {
                    flight = f;
                } 
            }
        }

        if (flight == null) 
        {
            throw new FlightNotFoundException(flightNum);
        }

        for (Passenger p : flight.passengerList)
        {
            p.print(); 
        }
    }

    // Write a simple inner class that implements the Comparator interface (NOTE: not *Comparable*)
    // This means you will be able to compare two Flight objects by departure time
    private class DepartureTimeComparator implements Comparator<Flight> 
    {
        @Override
        public int compare(Flight f1, Flight f2) 
        {
            return Integer.parseInt(f1.getDepartureTime()) - Integer.parseInt(f2.getDepartureTime());
        }
    }

    //Sort the array list of flights by increasing flight duration
    // Essentially one line of code but you will be making use of a Comparator object below
    public void sortByDuration() 
    {
        flights.sort(new DurationComparator());
    }

    //Write a simple inner class that implements the Comparator interface (NOTE: not *Comparable*)
    // This means you will be able to compare two Flight objects by duration
    private class DurationComparator implements Comparator<Flight> 
    {
        @Override
        public int compare(Flight f1, Flight f2) 
        {
            return f1.getFlightDuration() - f2.getFlightDuration();
        }
    }

    // Prints all aircraft in airplanes array list.
    // See class Aircraft for a print() method
    public void printAllAircraft() 
    {
        for (Aircraft a : airplanes)
        {
            a.print(); 
        }
    }

    // Sort the array list of Aircraft objects
    // This is one line of code. Make sure class Aircraft implements the Comparable interface
    public void sortAircraft() 
    {
        Collections.sort(airplanes);
    }

}
