/*
 * This program uses a boolean method isLeapYear to determine if the given parameter number is a year
 * on which a leap year occurs 
 */

public class IsLeapYear
{
   public static void main(String[] args)
   {
	   System.out.println("Year 500 is a Leap Year: " + isLeapYear(500) + "   Expected: false") ;
	   System.out.println("Year 2020 is a Leap Year: " + isLeapYear(2020) + "   Expected: true") ;
	   System.out.println("Year 1000 is a Leap Year: " + isLeapYear(1000) + "   Expected: false") ;
	   System.out.println("Year 100 is a Leap Year: " + isLeapYear(100) + "   Expected: false") ;
	   System.out.println("Year 1724 is a Leap Year: " + isLeapYear(1724) + "   Expected: true") ;
	   
   } 

/**
      Determines if input is a leap year.
      @param year current year (integer)
      @return true if year is a leap year, false otherwise
   */
   //$start Write a static method isLeapYear. This method returns a boolean (true of false). It takes one parameter: an integer value - the year
   // A year is a leap year if it is exactly divisible by 400 (i.e. remainder is 0) 
   // If it is not divisible by 400 then a year is also a leap year if it is exactly divisible by 4 AND it is NOT exactly divisible by 100
   // Hint: use the modulus operator % to check if exactly divisible 
   public static boolean isLeapYear(int year)
   {
      if (year % 400 == 0)
      {
         return true;
      }
      if (year % 4 == 0 && year % 100 != 0)
      {
         return true;
      }
      return false;
   }
   //$end
}