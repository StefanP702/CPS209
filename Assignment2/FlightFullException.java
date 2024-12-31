public class FlightFullException extends Exception 
{
    FlightFullException(String flightNum) 
    {
        super("Flight " + flightNum + " Full");
    }
}
