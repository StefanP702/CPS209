import java.util.Objects;

/*
 * A simple class to model an electronic airline flight reservation
 * 
 * This class has been done for you
 */
public class Reservation 
{
    String flightNum;
    String flightInfo;
    boolean firstClass;
    String passengerName;
    String passengerPassport;
    String seat;

    public Reservation(String flightNum, String info, Passenger passenger) 
    {
        this.flightNum = flightNum;
        this.flightInfo = info;
        this.passengerName = passenger.getName();
        this.passengerPassport = passenger.getPassport();
        this.seat = String.valueOf(passenger.getSeat());
        firstClass = passenger.getSeatType().equals(LongHaulFlight.firstClass);
    }

    public boolean isFirstClass() 
    {
        return firstClass;
    }

    public void setFirstClass() 
    {
        this.firstClass = true;
    }

    public String getFlightNum() 
    {
        return flightNum;
    }

    public String getFlightInfo() 
    {
        return flightInfo;
    }

    public void setFlightInfo(String flightInfo) 
    {
        this.flightInfo = flightInfo;
    }

    public void print() 
    {
        System.out.printf("%s %s %s %s\n", flightInfo, passengerName, passengerPassport, seat);
    }

    public String getPassengerPassport() 
    {
        return passengerPassport;
    }

    public String getPassengerName() 
    {
        return passengerName;
    }

    public String getSeat() 
    {
        return seat;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (this == o) 
        {
            return true; 
        }
        if (o == null || getClass() != o.getClass()) 
        {
            return false; 
        }
        Reservation that = (Reservation) o;
        return Objects.equals(flightNum, that.flightNum) && Objects.equals(passengerName, that.passengerName) && Objects.equals(passengerPassport, that.passengerPassport);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(flightNum, passengerName, passengerPassport);
    }
}
