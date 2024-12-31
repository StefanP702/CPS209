public class FlightNotFoundException extends Exception {
    FlightNotFoundException(String flightNum) {
        super( "Flight " + flightNum + " Not Found");
    }
}
