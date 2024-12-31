
/**
   Daily appointment.
*/
public class Daily extends Appointment
{

   /**
      Initializes appointment for a given date.
      @param year the year
      @param month the month
      @param day the day
      @param description the text description of the appointment
   */
   public Daily(int year, int month, int day, String description)
   {
  	 //$start Initialize the inherited variables - make use of the super() keyword
      super(year, month, day, description);
      //$end
   }

   /**
      Determines if the date is later than the appointment date
      @param year the year
      @param month the month
      @param day the day
      @return true if base appointment is earlier than the appointment date
   */
   public boolean occursOn(int year, int month, int day)
   {
  	  //$start Override occursOn. Checks the given date parameters year, month, day to see if it is a later
  	  // date than the appointment date stored in this object. Return true if so, false otherwise
      if (year > getYear())
      {
         return true;
      }
      if (year == getYear())
      {
         if (month > getMonth())
         {
            return true;
         }
         if (month == getMonth())
         {
            if (day >= getDay())
            {
               return true;
            }
         }
      }
      return false;
      //$end
   }
}

