/*
 * This program calculates a tax refund amount based on the income for the year and the number of children a person has
 * The rules are:
 * 
 * Income > 30000$ and <= 40000$ and ch >= 3, refund is 1000.0$ * ch
 * Income > 20000$ and <= 30000$ and ch >= 2, refund is 1500.0$ * ch
 * Income <= 20000$, refund is 2000.0$ * ch
 * 
 * For example, if the income was 34312$ and the number of children (ch) was 7 then the tax refund would be: 1000*7 = 7000.0$
 * 
 */
import java.util.Scanner;

public class RefundAmount
{
   public static void main(String[] args)
   {
	   System.out.println("Refund: " + refund(23000.0,2) + "   Expected: 3000.0") ;
	   System.out.println("Refund: " + refund(17500.0,4) + "   Expected: 8000.0") ;
	   System.out.println("Refund: " + refund(80000.0,9) + "   Expected: 0.0") ;
	   System.out.println("Refund: " + refund(35000.0,5) + "   Expected: 5000.0") ;
	   System.out.println("Refund: " + refund(35000.0,-1) + "   Expected: 0.0") ;
   }
	
	/**
      Calculates the refund amount based on income and number of children.
            
      @param income (double)
      @param ch number of children (int)
      @return refund amount (double)
      
      return 0 unless:
      Income > 30000$ and <= 40000$ and ch >= 3, refund is 1000.0$ * ch
      Income > 20000$ and <= 30000$ and ch >= 2, refund is 1500.0$ * ch
      Income <= 20000$, refund is 2000.0$ * ch
      
      check to make sure ch > 0, return 0 if not
   */
   //$start write a static method called refund with the appropriate parameters and return type.  
   public static double refund(double income, int ch)
   {
      if (ch > 0)
      {
         if (income > 30000 && income <= 40000 && ch >=3)
         {
             return 1000.0 * ch;
         }
         else if (income > 20000 && income <= 30000 && ch >=2)
         { 
            return 1500.0 * ch;
         }
         else if (income <= 20000)
         {
            return 2000.0 * ch;
         }
         
      }
      return 0.0; 
   }
   //$end
}
