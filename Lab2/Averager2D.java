/**
   Finding the average of all elements in a 2D array of integers.
 */
import java.util.* ;

public class Averager2D
{
	public static void main(String[] args)
	{
		//a 2D array
		int[][] a = {{5, 9, 3, 2, 14}, {77, 44, 22, 15, 99},
		         		 {14, 2, 3, 9, 5}, {88, 15, 17, 121, 33}} ;
		System.out.printf("Average = %.2f\n", average(a)) ;
		System.out.println("EXPECTED:") ;
		System.out.println("Average = 29.85") ;
		System.out.printf("Average of evens = %.2f\n", averageEvens(a)) ;
		System.out.println("EXPECTED:") ;
		System.out.println("Average of evens = 26.57") ;
		
		Random random = new Random(1) ;
		a = new int[100][1] ;
		for (int i = 0 ; i < 100 ; i++)
		{
			a[i][0] = random.nextInt(1000) ;
		}
		System.out.println("For an array of random values in range 0 to 999:") ;
		System.out.printf("Average = %.2f\n", average(a)) ;
		System.out.println("EXPECTED:") ;
		System.out.println("Average = 510.56") ;
		System.out.printf("Average of evens = %.2f\n", averageEvens(a)) ;
		System.out.println("EXPECTED:") ;
		System.out.println("Average of evens = 557.89") ;
	}
  /**
     Find the average of all elements of a two-dimensional array
     @param aa the two dimensional array
     @return the average as a double
   */
  public static double average(int[][] aa)
  {
  	//$start 1. declare and initialize variable total to zero ; Hint: use a double 
  	double total = 0 ;
  	//2. use a nested for loop to visit each element ; 
    for(int i = 0; i < aa.length; i++) 
    {
    	for(int j = 0; j < aa[0].length; j++) 
    	{
    		//3. increase total with each element ; 
        total += aa[i][j] ;
      }
    }
	  //4. return the average
    return total / (aa.length * aa[0].length) ;
    //$end
  }
    /**
       Find the average of the even elements of a two-dimensional array and return it
       @param aa the two dimensional array
       @return the average as a double
     */
    public static double averageEvens(int[][] aa)
    {
    	//$start fill in the method
      double total = 0 ;
      int count = 0 ;
      for(int i = 0; i < aa.length; i++) 
      {
      	for(int j = 0; j < aa[0].length; j++) 
      	{
      		if (aa[i][j] % 2 == 0) 
      		{
      			total += aa[i][j] ;
      			count ++ ;
      		}		
      	}
      }
      return total / count ;
      //$end
    }
}
