
/** A class for representing a microwave oven.
 */
public class Microwave {
    
   
    int timer;
    String power; //HIGH or LOW
    
    /** Creates a microwave with 0 seconds on the timer and at LOW power.
     */
    public Microwave()
    {
        //$start Complete this constructor to initialize instance variables
    	  timer = 0;
    	  power = "LOW";
    	  //$end
    }
    
    /** Increases the time on the timer by 30 seconds.
     */
    public void increaseTime()
    {
       //$start complete the method
    	timer += 30;
    	//$end
    }
    
    /** Switches the power level from LOW to HIGH, or vice versa.
     */
    public void switchPower()
    {
       //$start Complete this method. 
    	 if (power.equals("LOW"))
    		 power = "HIGH";
    	 else
    		 power = "LOW";
    	 //$end
    }
    
    /** Resets the microwave to its initial state.
     */
    public void reset()
    {
      //$start Complete this method. 
    	timer = 0;
  	  power = "LOW";
  	  //$end
    }
    
    public void start()
    {
       System.out.println("Cooking for " + timer + " seconds at power " + power);  
    }
   
}
