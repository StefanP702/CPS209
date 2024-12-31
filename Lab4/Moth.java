/**
   A class that simulates a moth flying.
*/
public class Moth
{
   private double position;

   /**
      Initializes the moth given a position.
      @param initialPosition the initial position
   */
   public Moth(double initialPosition)
   {
  	  //$start set the position to the given parameter initialPosition
      position = initialPosition;
      //$end
   }
   
   /**
      Moves the moth halfway to the lightPosition.
   */
   public void moveToLight(double lightPosition) 
   {
  	 //$start update the current position to be halfway to (i.e. closer so position should be getting smaller) the lightPosition 
      position -= (position - lightPosition) / 2;
      //$end
   }
   
   /**
      Reports the current position of the moth.
      @return the current position
   */
   public double getPosition() 
   {
      return position;
   }
   
    public static void main(String[] args)
   {
      Moth myMoth = new Moth(10);
      myMoth.moveToLight(20);
      System.out.println("Expected position 15.0; Current position " + myMoth.getPosition());
      myMoth.moveToLight(0);
      System.out.println("Expected position 7.5; Current position "  + myMoth.getPosition());
      myMoth.moveToLight(0);
      System.out.println("Expected position 3.75; Current position " + myMoth.getPosition());
      myMoth.moveToLight(0);
      System.out.println("Expected position 1.875: Current position " + myMoth.getPosition());
   }
}

