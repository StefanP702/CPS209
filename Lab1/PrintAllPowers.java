/*
 * This program calculates the powers of 2 from power = 0 to power = 20 and adds them together
 * For example, to add all powers of 2 from power = 2 to power = 4 then the result is:
 * 2^2 = 4 plus 2^3 = 8 plus 2^4 = 16 so the final result is: 4+8+16 = 28
 * 
 * 
 */
public class PrintAllPowers 
{
	public static void main(String[] args)
	{
		//$start Create an integer variable called sum and initialize it to 0
		int sum = 0;
		//$end
		
	  //$start Write a for loop that counts from 0 to 20 (inclusive). Declare and use a variable called power as the loop variable
	  // Inside the loop use the Math.pow(double a, double b) function compute 2^power and add it to the sum variable
		for (int power = 0; power <= 20; power++)
	  {
	    sum += (int) Math.pow(2, power);
	  }
	  //$end 
	  System.out.println("Sum = " + sum ) ;
	  System.out.println("Expected: ") ;
	  System.out.println("Sum = " + 2097151) ;
	 
	
    //$start Reset sum variable to 0 and then repeat the loop as above
    // Inside the loop, instead of calling Math.pow, use an inner loop to calculate 2^power and add the result to the sum variable
	  sum = 0;
	  for (int power = 0; power <= 20; power++)
    {
	  	int result = 1;
	  	for (int i = 0; i < power; i++)
	  	{
	  	  result *=2;
	  	}
	  	sum += result;
    }
    //$end 
    System.out.println("Sum = " + sum ) ;
    System.out.println("Expected: ") ;
    System.out.println("Sum = " + 2097151) ;
  }
}