/**
   This class models a tally counter.
*/
public class Counter
{
   private int value;
   private int max;

   public void setLimit(int maximum)
   {
      max = maximum;
   }

   /**
      Gets the current value of this counter.
      @return the current value
   */
   public int getValue()
   {
      return value;
   }

   /**
      Advances the value of this counter by 1.
   */
   public void count() 
   {
  	 //$start increments value by 1. if value exceeds limit, print "Limit Exceeded" and reset value to 0
      value = value + 1;
      if (value > max)
      {
         System.out.println("Limit exceeded");
         reset();
      } 
      //$end
   }

   /**
      Resets the value of this counter to 0.
   */
   public void reset()
   {
      value = 0;
   }
}
