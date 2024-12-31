/**
   This is a simple program to count the lines in a data file

 */
import javax.swing.* ;
import java.util.* ;
import java.io.* ;

public class LineCount
{
	public static void main(String[] args) 
	{
		//$start Use a try{...}catch(){...} block and open a file "data.txt" using the File class. 
		// Create a Scanner object and pass in the File reference. Read the lines one at a time from the file
		// and count them. Print "Number of lines: " followed by the line count
		try
		{
			File file = new File("data.txt") ;
			Scanner scanner = new Scanner(file) ;
			int count = 0 ;
			
			while (scanner.hasNext()) 
			{
				count++ ;
				String line = scanner.nextLine() ;
			}
			System.out.println("Number of lines: " + count) ;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		//$end
		System.out.println("Expected:\nNumber of lines: 13");
	}
}
