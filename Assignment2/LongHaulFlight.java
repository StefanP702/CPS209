/*
 * A long haul flight is a flight that travels thousands of kilometers and typically has separate seating areas 
 */

public class LongHaulFlight extends Flight 
{
    int numFirstClassPassengers;
    String seatType;

    // Possible seat types
    public static final String firstClass = "First Class Seat";
    public static final String economy = "Economy Seat";

    public LongHaulFlight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft) 
    {
        // use the super() call to initialize all inherited variables
        // also initialize the new instance variables
        super(flightNum, airline, dest, departure, flightDuration, aircraft);
        numFirstClassPassengers = 0;
        seatType = firstClass;
        flightType = FlightType.LONGHAUL;
    }

    public LongHaulFlight() 
    {
        // default constructor
        super();
    }

    /*
     * Reserves a seat on a flight. Essentially just increases the number of passengers, depending on seat type (economy or first class)
     */
    public void reserveSeat(Passenger passenger, String seat) throws SeatOccupiedException, DuplicatePassengerException //created these two exceptions in 
    {
        super.reserveSeat(passenger, seat);
        numFirstClassPassengers++;
    }

    // Cancel a seat 
    public void cancelSeat(Passenger passenger) throws PassengerNotInManifestException 
    {
        super.cancelSeat(passenger);
        if (passenger.getSeatType().equals(LongHaulFlight.firstClass))
        {
            numFirstClassPassengers--;  
        }
    }

    // return the total passenger count of economy passengers *and* first class passengers
    // use instance variable at top and inherited method that returns economy passenger count
    public int getPassengerCount() 
    {
        return numFirstClassPassengers + getPassengers();
    }

    @Override
    public String toString() 
    {
        return super.toString() + "\tLongHaul";
    }

    @Override

    public FlightType getFlightType() 
    {
        return FlightType.LONGHAUL;
    }
}
