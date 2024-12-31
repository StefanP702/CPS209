/*
 * A long haul flight is a flight that travels thousands of kilometers and typically has separate seating areas 
 */

public class LongHaulFlight extends Flight {
    int numFirstClassPassengers;
    String seatType;

    // Possible seat types
    public static final String firstClass = "First Class Seat";
    public static final String economy = "Economy Seat";

    public LongHaulFlight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft) {
        // use the super() call to initialize all inherited variables
        // also initialize the new instance variables

        super(flightNum, airline, dest, departure, flightDuration, aircraft);

        numFirstClassPassengers = 0;
        seatType = firstClass;
    }

    public LongHaulFlight() 
    {
        // default constructor
        super();
    }

    /*
     * Reserves a seat on a flight. Essentially just increases the number of (economy) passengers
     */
    public boolean reserveSeat() 
    {
        return super.reserveSeat();
    }

    /*
     * Reserves a seat on a flight. Essentially just increases the number of passengers, depending on seat type (economy or first class)
     */
    public boolean reserveSeat(String seatType) 
    {
        if(seatType.equals(economy))
        {
            return super.reserveSeat(); 
        }
        else
        {
            if(numFirstClassPassengers + 1 <= aircraft.getNumFirstClassSeats())
            {
                numFirstClassPassengers += 1;
                return true;
            }
            return false;
        }
    }
    // Cancel a seat 
    public void cancelSeat() 
    {
        super.cancelSeat();
    }

    public void cancelSeat(String seatType) 
    {
        if(seatType.equals(firstClass) && numFirstClassPassengers > 0)
        {
            numFirstClassPassengers--; 
        } 
        else 
        {
            super.cancelSeat(); 
        }
    }

    public int getPassengerCount() 
    {
        return numFirstClassPassengers + getPassengers();
    }

    @Override
    public String toString() 
    {
        return super.toString() + "\tLongHaul";
    }
}
