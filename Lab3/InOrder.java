/*
 * This program determines whether an array of integer elements is in incrrasing order
 * For example: 1, 2, 3, 4, 5, 6, 7, 8, 9, 42 is in increasing order
 * but array: 2, 1, 3, 4, 5, 6, 7, 8, 9, 42 is not
 */

public class InOrder
{
	
/*
 * Takes an input array of integer elements as parameter and determines if the
 * elements are in increasing order. If so, return true else return false
 */
public static boolean inOrder(int[] arr)
{
   //$start Loop through the given array arr checking for out of order elements
   boolean ordered = true;
   
   for (int i = 0; i < arr.length - 1; i++)
   {
      if (arr[i] > arr[i + 1])
      {
         ordered = false;
      }
   }
   return ordered;
   //$end
}

public static void main(String[] args)
{
   int[] arrOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9, 42};
   int[] arrNotOrder = {2, 1, 3, 4, 5, 6, 7, 8, 9, 42};

   // Check if array 1 is ordered or not.
   if (inOrder(arrOrder))
   {
      System.out.println("The array is in order.");
   }
   else
   {
      System.out.println("The array is NOT in order.");
   }
   System.out.println("Expected:\nThe array is in order.");


   // Check if array 2 is ordered or not.
   if (inOrder(arrNotOrder))
   {
      System.out.println("The array is in order.");
   }
   else
   {
      System.out.println("The array is NOT in order.");
   }
   System.out.println("Expected:\nThe array is NOT in order.");
}
}