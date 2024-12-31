import java.util.Objects;

/* Class Passenger is that contains a name, passports number and seat field. Its a class that 
 * has an overriden boolean equals(Object other) method from the superclass Object based on name 
 * and passport 
 */
public class Passenger 
{
    private String name;
    private String passport;
    private int seatNumber;

    Passenger(String name, String passport, int seatNumber) 
    {
        this.name = name;
        this.passport = passport;
        this.seatNumber = seatNumber;
    }

    public String getName() 
    {
        return name;
    }

    public String getPassport() 
    {
        return passport;
    }

    public int getSeatNumber() 
    {
        return seatNumber;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setPassport(String passport) 
    {
        this.passport = passport;
    }

    public void setSeatNumber(int seatNumber) 
    {
        this.seatNumber = seatNumber;
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
        System.out.println(name + "\t" + passport + "\t" + seatNumber);
    }
}
