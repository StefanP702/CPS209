import java.util.Arrays;
/*
 * 
 * This program takes an array of integers, reverses the elements and stores them in a new array
 * 
 */
public class ReverseElements
{
   /**
      Reverses an array.
      @param data - the input array
      @return an array with the elements of data in reverse order
   */
   public static int[] reverse(int[] data)
   {
  	  //$start
      int[] revData = Arrays.copyOf(data, data.length);
      int j = 0;
      for (int i = data.length - 1; i >= 0; i--) 
      {
         revData[j] = data[i];
         j++;
      }
      return revData;
      //$end
   }
   
   
   public static void main(String[] args)
   {
      int[] data = { 1, 4, 9, 16, 9, 7, 4, 9, 11 };
      int[] reversed = reverse(data);
      for (int i = 0; i < reversed.length; i++) 
      {
         System.out.print(reversed[i] + " ");
      }
      System.out.println();
      System.out.println("Expected:\n11 9 4 7 9 16 9 4 1");
   }
}
