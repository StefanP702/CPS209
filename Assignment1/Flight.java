import java.util.ArrayList;

/*
 *  Class to model an airline flight. In this simple system, all flights originate from Toronto
 *  
 *  This class models a simple flight that has only economy seats
 */
public class Flight 
{

    public enum Status {DELAYED, ONTIME, ARRIVED, INFLIGHT};

    String flightNum;
    String airline;
    String origin, dest;
    String departureTime;
    Status status; // see enum Status above. google this to see how to use it
    int flightDuration;
    Aircraft aircraft;
    protected int passengers; // count of (economy) passengers on this flight - initially 0

    ArrayList<Passenger> passengerList = new ArrayList<>();

    public Flight() 
    {
        // write code to initialize instance variables to default values
        flightNum = "";
        airline = "";
        origin = "";
        dest = "";
        departureTime = "";
        status = Status.DELAYED;
        flightDuration = 0;
        aircraft = null;
        passengers = 0;
    }

    public Flight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft) {
        this.flightNum = flightNum;
        this.airline = airline;
        this.dest = dest;
        this.origin = "Toronto";
        this.departureTime = departure;
        this.flightDuration = flightDuration;
        this.aircraft = aircraft;
        passengers = 0;
        status = Status.ONTIME;
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
    public boolean seatsAvailable() 
    {
        // your code here
        return aircraft.getNumSeats() > passengers;
    }

    /*
     * Cancel a seat - essentially reduce the passenger count by 1. Make sure the count does not
     * fall below 0 (see instance variable passenger)
     */
    public void cancelSeat() 
    {
        if (passengers > 0)
        {
            passengers--; 
        }
    }

    /*
     * reserve a seat on this flight - essentially increases the passenger count by 1 only if there is room for more
     * economy passengers on the aircraft used for this flight (see instance variables above)
     */
    public boolean reserveSeat() 
    {
        if (seatsAvailable()) 
        {
            passengers++;
            return true;
        }
        return false;
    }

    public boolean reserveSeat(String name, String passport) 
    {
        Passenger passenger = new Passenger(name, passport, 0);
        for (Passenger p : passengerList)
        {
            if (p.equals(passenger)) 
            {
                return false;
            }  
        }   
        passengerList.add(passenger);
        return reserveSeat();
    }

    public String toString() 
    {
         return airline + "\t Flight:  " + flightNum + "\t Dest: " + dest + "\t Departing: " + departureTime + "\t Duration: " + flightDuration + "\t Status: " + status;
    }

    public Passenger getLastPassenger() 
    {
        if (passengerList.isEmpty())
        {
            return null;
        }
        return passengerList.get(passengerList.size() - 1);
    }
}
