/**
   Converts Roman numerals to decimal value. For example, if the Roman numeral is X then the valueOf method returns 10
   The valueOf method assumes the parameter is one of either: I X L C D M
*/
import java.util.Scanner;

public class RomanNumerals
{
	public static void main(String[] args)
	{
	   Scanner in = new Scanner("I C X D M L");

	   char romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 1") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 100") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 10") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 500") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 1000") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 50") ;
	}
	
   /**
      Returns the integer value of the given Roman numeral (one of I X L C D M)
      @param numeral a single Roman numeral (char)
      @return the integer value of numeral
   */
   //$start write a static method valueOf with the appropriate parameters and return type. 	
   public static int valueOf(char numeral)
   {
      if (numeral == 'I')
      {
         return 1;
      }
      if (numeral == 'V')
      {
         return 5;
      }
      if (numeral == 'X')
      {
         return 10;
      }
      if (numeral == 'L')
      {
         return 50;
      }
      if (numeral == 'C')
      {
         return 100;
      }
      if (numeral == 'D')
      {
         return 500;
      }
      // must be an M
      return 1000;
   }
   //$end
}
