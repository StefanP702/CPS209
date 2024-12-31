import java.util.Objects;

public class Passenger extends Person implements Comparable<Passenger> 
{
    private String passport;
    private String seat;
    private String seatType;

    Passenger(String name, String passport, String seat, String seatType) 
    {
        super(name);
        this.passport = passport;
        this.seat = seat;
        this.seatType = seatType;
    }

    public String getPassport() 
    {
        return passport;
    }

    public String getSeat() 
    {
        return seat;
    }

    public String getSeatType() 
    {
        return seatType;
    }

    public void setPassport(String passport) 
    {
        this.passport = passport;
    }

    public void setSeat(String seat) 
    {
        this.seat = seat;
    }

    public void setSeatType(String seatType) 
    {
        this.seatType = seatType;
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
        Passenger passenger = (Passenger) o;
        return Objects.equals(name, passenger.name) && Objects.equals(passport, passenger.passport);
    }

    public void print() 
    {
        System.out.println(name + " " + passport + " " + seat);
    }

    @Override
    public String toString() 
    {
        return name + ' ' + passport + ' ' + seat;
    }

    @Override
    public int compareTo(Passenger passenger) 
    {
        return this.seat.compareTo(passenger.getSeat());
    }
}
