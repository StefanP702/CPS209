import java.util.*;
/*
 *  Class to model an airline flight. In this simple system, all flights originate from Toronto
 *  
 *  This class models a simple flight that has only economy seats
 */
public class Flight 
{

    public enum Status {DELAYED, ONTIME, ARRIVED, INFLIGHT};

    private String flightNum;
    private String airline;
    private String origin, dest;
    private String departureTime;
    private Status status; // see enum Status above. google this to see how to use it
    private int flightDuration;
    private Aircraft aircraft;
    protected int passengers; // count of (economy) passengers on this flight - initially 0
    protected FlightType flightType;
    private boolean boarded;
    private PriorityQueue<Passenger> queue = new PriorityQueue<>();
    private HashSet<CrewMember> crews = new HashSet<>();

    protected ArrayList<Passenger> manifest = new ArrayList<>();
    protected TreeMap<String, Passenger> seatMap = new TreeMap<>();

    public static enum FlightType {SHORTHAUL, MEDIUMHAUL, LONGHAUL};

    public Flight() 
    {
        // write code to initialize instance variables to default values
        flightNum = "";
        airline = "";
        origin = "Toronto";
        dest = "";
        departureTime = "";
        status = Status.ONTIME;
        flightDuration = 0;
        aircraft = null;
        passengers = 0;
        flightType = FlightType.MEDIUMHAUL;
        boarded = false;
    }

    public Flight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft) 
    {
        this.flightNum = flightNum;
        this.airline = airline;
        this.dest = dest;
        this.origin = "Toronto";
        this.departureTime = departure;
        this.flightDuration = flightDuration;
        this.aircraft = aircraft;
        passengers = 0;
        status = Status.ONTIME;
        flightType = FlightType.MEDIUMHAUL;
        boarded = false;
    }

    public String getFlightNum() 
    {
        return flightNum;
    }

    public void setFlightNum(String flightNum) 
    {
        this.flightNum = flightNum;
    }

    public String getAirline() 
    {
        return airline;
    }

    public void setAirline(String airline) 
    {
        this.airline = airline;
    }

    public String getOrigin() 
    {
        return origin;
    }

    public void setOrigin(String origin) 
    {
        this.origin = origin;
    }

    public String getDest() 
    {
        return dest;
    }

    public void setDest(String dest) 
    {
        this.dest = dest;
    }

    public String getDepartureTime() 
    {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) 
    {
        this.departureTime = departureTime;
    }

    public Status getStatus() 
    {
        return status;
    }

    public void setStatus(Status status) 
    {
        this.status = status;
    }

    public int getFlightDuration() 
    {
        return flightDuration;
    }

    public void setFlightDuration(int dur) 
    {
        this.flightDuration = dur;
    }

    public int getPassengers() 
    {
        return passengers;
    }

    public void setPassengers(int passengers)
    {
        this.passengers = passengers;
    }

    // Check to see if there is room on this flight - compare current passenger count
    // with aircraft max capacity of economy seats
    public boolean seatsAvailable(String seat) 
    {
        // your code here
        int col, row;
        if (seat.charAt(seat.length() - 1) == '+') 
        {
            row = seat.charAt(seat.length() - 2) - 'A';
            col = Integer.parseInt(seat.substring(0, seat.length() - 2)) - 1;
        } 
        else 
        {
            row = seat.charAt(seat.length() - 1) - 'A';
            col = Integer.parseInt(seat.substring(0, seat.length() - 1)) - 1;
        }

        return aircraft.seatLayout[row][col] == null;
    }

    /*
     * Cancel a seat - essentially reduce the passenger count by 1. Make sure the count does not
     * fall below 0 (see instance variable passenger)
     */
    public void cancelSeat(Passenger passenger) throws PassengerNotInManifestException 
    {
        int size = manifest.size();
        manifest.removeIf(p -> p.equals(passenger));

        if (size == manifest.size())
        {
            throw new PassengerNotInManifestException(passenger); 
        }

        String seat = passenger.getSeat();
        int col, row;
        if (seat.charAt(seat.length() - 1) == '+') 
        {
            row = seat.charAt(seat.length() - 2) - 'A';
            col = Integer.parseInt(seat.substring(0, seat.length() - 2)) - 1;
        } 
        else 
        {
            row = seat.charAt(seat.length() - 1) - 'A';
            col = Integer.parseInt(seat.substring(0, seat.length() - 1)) - 1;
            passengers--;
        }
        aircraft.seatLayout[row][col] = null;
        seatMap.remove(seat);

        queue.remove(passenger);
    }

    /*
     * reserve a seat on this flight - essentially increases the passenger count by 1 only if there is room for more
     * economy passengers on the aircraft used for this flight (see instance variables above)
     */

    public void reserveSeat(Passenger passenger, String seat) throws DuplicatePassengerException, SeatOccupiedException 
    {
        if (!seatsAvailable(seat)) 
        {
            throw new SeatOccupiedException(seat);
        }

        for (Passenger p : manifest)
        {
            if (p.equals(passenger))
            {
                throw new DuplicatePassengerException(p); 
            }
        }
        int col, row;
        if (seat.charAt(seat.length() - 1) == '+') 
        {
            passenger.setSeatType(LongHaulFlight.firstClass);
            row = seat.charAt(seat.length() - 2) - 'A';
            col = Integer.parseInt(seat.substring(0, seat.length() - 2)) - 1;
        } 
        else 
        {
            passenger.setSeatType(LongHaulFlight.economy);
            row = seat.charAt(seat.length() - 1) - 'A';
            col = Integer.parseInt(seat.substring(0, seat.length() - 1)) - 1;
            passengers++;
        }

        aircraft.seatLayout[row][col] = seat;
        seatMap.put(seat, passenger);

        manifest.add(passenger);
    }

    public void printPassengerManifest() 
    {
        for (Passenger p : manifest)
        {
            p.print(); 
        }
    }

    public void printSeats() 
    {
        int rows = aircraft.getRows();
        int cols = aircraft.getCols();
        int numFirstClass = aircraft.getNumFirstClassSeats();

        for (int i = 0; i < rows; i++) 
        {
            int numPerRow = numFirstClass / rows;
            for (int j = 0; j < cols; j++) 
            {
                String seat = String.format("%d%c", j + 1, 'A' + i);

                if (seatMap.containsKey(seat))
                    System.out.print("XX ");
                else if (seatMap.containsKey(seat + "+"))
                    System.out.print("XX "); 
                else 
                {
                    if(numPerRow > 0) 
                    {
                        System.out.print(seat + "+ ");
                        numPerRow--;
                    } 
                    else
                    {
                        System.out.print(seat + " "); 
                    }
                }
            }

            System.out.println();
        }

        System.out.println("\n");
        System.out.println("XX = Occupied  + = First class");
    }

    public String toString() {
        return airline + "\t Flight:  " + flightNum +
        "\t Dest: " + dest +
        "\t Departing: " + departureTime
        + "\t Duration: " + flightDuration
        + "\t Status: " + status;
    }

    public FlightType getFlightType() 
    {
        return flightType;
    }

    public void createPreboardQueue() 
    {
        queue.clear();
        queue.addAll(manifest);
    }

    public void printQueue() 
    {
        for (Passenger p : queue)
        {
            p.print(); 
        }
    }

    public void board(int startRow, int endRow) 
    {
        while (true) 
        {
            int size = queue.size();
            for (Passenger p : queue) 
            {
                String seat = p.getSeat();
                if (seat.charAt(seat.length() - 1) == '+')
                {
                    seat = seat.substring(0, seat.length() - 2); 
                }
                else
                {
                    seat = seat.substring(0, seat.length() - 1); 
                }

                int val = Integer.parseInt(seat);
                if (val >= startRow && val <= endRow)
                {
                    queue.remove(p); 
                }
            }

            if (size == queue.size())
            {
                break; 
            }
        }

        this.status = Status.INFLIGHT;
    }

    public void addCrew(CrewMember member) throws DuplicateCrewException 
    {
        if (crews.contains(member))
        {
            throw new DuplicateCrewException(member); 
        }
        crews.add(member);
    }

    public void removeCrew(CrewMember member) throws CrewNotInFlightException 
    {
        if (!crews.contains(member))
        {
            throw new CrewNotInFlightException(member); 
        }
        crews.remove(member);
    }

    public void printCrews() 
    {
        for (CrewMember c : crews)
        {
            c.print(); 
        }
    }

    public boolean containsCrew(CrewMember member) 
    {
        return crews.contains(member);
    }

}

class DuplicatePassengerException extends Exception 
{
    DuplicatePassengerException(Passenger p) 
    {
        super("Duplicate Passenger " + p.getName() + " " + p.getPassport());
    }
}

class PassengerNotInManifestException extends Exception 
{
    PassengerNotInManifestException(Passenger p) 
    {
        super("Passenger " + p.getName() + " " + p.getPassport() + " Not In Manifest");
    }
}

class SeatOccupiedException extends Exception 
{
    SeatOccupiedException(String seat) 
    {
        super("Seat " + seat + " already occupied");
    }
}

class DuplicateCrewException extends Exception 
{
    DuplicateCrewException(CrewMember c) 
    {
        super("Duplicate Crew " + c.getName() + " " + c.getTitle());
    }
}

class CrewNotInFlightException extends Exception 
{
    CrewNotInFlightException(CrewMember c) 
    {
        super("Crew " + c.getName() + " " + c.getTitle() + " Not In Flight");
    }
}

class CrewOccupiedException extends Exception 
{
    CrewOccupiedException(CrewMember c) 
    {
        super("Crew " + c.getName() + " " + c.getTitle() + " already occupied");
    }
}

