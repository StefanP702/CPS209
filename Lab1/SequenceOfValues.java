import java.util.Scanner;
/*
 * This program reads double values from a list (actually a string) using a scanner. It calculates the average of these values as
 * well as the minimum value and the maximum value
 * For example, if the values are: 20 10 30 40 then the average is (20+10+30+40)/4 = 25 and the min is 10 and the max is 40
 */
public class SequenceOfValues
{
   public static void main(String[] args)
   {
     String numbers = "34 68 22 76.0 81 98 78 84 62"; 
  	 Scanner in = new Scanner(numbers);
     
      boolean first = true;
      double min = 0;
      double max = 0;
      double sum = 0.0;

      // Use this variable to keep track of the number of floating point numbers read in from numbers
      int numberOfValuesSeen = 0;
      //$start Use a while loop and read one number at a time using the scanner. Inside the loop, update variable sum and update variables min and max if necessary
      // Don't forget to increment variable numberOfValuesSeen
      // Use the boolean variable first (declared above) to determine if this is the first time through the loop. 
      // If so, set sum, min, max to the first value read from the scanner and set first to false
      // Hint: never call in.nextDouble() more than once inside a loop - call it and assign the result to a variable. Use this variable to test the value
      while (in.hasNextDouble())
      {
         double value = in.nextDouble();
         numberOfValuesSeen++;
         if (first)
         {
            min = value;
            max = value;
            sum = value;
            first = false;
         }
         else
         {
            if (value < min)
            {
               min = value;
            }
            if (value > max)
            {
               max = value;
            }
            sum = sum + value;
         }
      }
      //$end
      System.out.printf("The average of the values is: %.2f%n", sum
         / numberOfValuesSeen);
      System.out.printf("The smallest value is %.2f%n", min);
      System.out.printf("The largest value is %.2f%n", max);
      System.out.printf("The range is %.2f%n", max - min);
      System.out.println("Expected: \nThe average of the values is: 67.00\r\nThe smallest value is 22.00\r\nThe largest value is 98.00\r\nThe range is 76.00");
   }
}
