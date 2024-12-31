
/**
   Monthly appointment.
*/
public class Monthly extends Appointment
{
   /**
      Initializes appointment for a given date.
      @param year the year
      @param month the month
      @param day the day
      @param description the text description of the appointment
   */
   public Monthly(int year, int month, int day, String description)
   {
  	  //$start Initialize the inherited variables - make sure of the super() keyword
      super(year, month, day, description);
      //$end
   }

   /**
      Determines if the appointment occurs on the same day of the month.
      @param year the year
      @param month the month
      @param day the day
      @return true if day matches the appointment date and is later than the
      appointment date stored in this object
   */
   public boolean occursOn(int year, int month, int day)
   {
  	  //$start Override the occursOn() method. Check to see if the appointment occurs on the
  	  // same day of the month and is later than the appointment date stored in this object . 
  	  if (year < getYear())
      {
         return false;
      }
      if (month < getMonth() && year == getYear())
      {
         return false;
      }
      return day == getDay();
      //$end
   }
}
