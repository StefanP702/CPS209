import java.util.Scanner;
/*
 * This program reads integer number from a scanner. If the number is between the limit numbers a and b and the number is odd, then add this number to a total
 *  
 */
public class SumOfOddNumbers 
{
   public static void main(String[] args) 
   {
  	 String aAndb = "20 60 1 30 70 90";
  	 Scanner ab = new Scanner(aAndb);
  	 
  	 String numbers = "7 67 23 18 16 99 45 51 42 64 33 71";    
  	
     
  	 while (ab.hasNextInt()) 
  	 {  
  	    int a = ab.nextInt();
        int b = ab.nextInt();
        
        Scanner in = new Scanner(numbers);
        int sum = 0;
        //$start Use a while loop, check for another integer num using Scanner in (hint: in.hasNextInt())
        // Get the next int and assign to variable. Use an if statement to check if the number is between a and b and is odd.
        // If so, add to the sum variable
        while (in.hasNextInt())
        {
          int num;
          num = in.nextInt();

          if (num >= a && num <=b && num%2!=0) 
          {
            sum = sum + num;
          }
        }
        //$end
        System.out.println("The sum is " + sum);
     }
  	 System.out.println("Expected:");
  	 System.out.println("The sum is 152");
  	 System.out.println("The sum is 30");
  	 System.out.println("The sum is 71");
  }
}
