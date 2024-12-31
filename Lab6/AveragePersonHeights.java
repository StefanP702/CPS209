
import java.util.ArrayList;
import java.util.Scanner;

/**
   A class to read and calculate the average height of many people.
*/
public class AveragePersonHeights
{
   /**
      Calculates the average measure from a collection of Measurable object
      @param objects the objects
      @return the average measure of objects
   */
   public static double average(Measurable[] objects)
   {
  	  //$start loop through the array of Measurable objects and add their measure to a total
  	  // compute and return the average measure
  	  // Hint: check to see if the length of the array is > 0 first. If it is == 0, return 0.0
      if (objects.length == 0)
      {
         return 0;
      }
      double sum = 0;
      for (Measurable obj : objects)
      {
         sum = sum + obj.getMeasure();
      }
      return sum / objects.length;
      //$end
   }

   public static void main(String[] args)
   {
      APerson[] people = new APerson[4];
      people[0] = new APerson("Larry", 65);
      people[1] = new APerson("Susan", 45);
      people[2] = new APerson("Joe", -45);
      people[3] = new APerson("", 0);
      System.out.println("The average height is: " + average(people));
      System.out.println("Expected:\nThe average height is: 16.25");
   }
}
