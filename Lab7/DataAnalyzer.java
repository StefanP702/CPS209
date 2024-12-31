import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
   This program reads a file containing numbers and analyzes its contents.
   If the file doesn't exist or contains strings that are not numbers, an
   error message is displayed.
 */
public class DataAnalyzer
{ 
	/**
      Reads a data set.
      @param filename the name of the file holding the data
      @return the data in the file
	 */
	//$start Make readFile() tell the compiler it will not handle any thrown checked exceptions
	public static double[] readFile(String filename) throws IOException
	//$end
	{   
		double[] values;

		Scanner in = new Scanner(new File(filename));
		int numberOfValues = in.nextInt();
		values = new double[numberOfValues];
		for (int i = 0; i < numberOfValues; i++)
		{
			values[i] = in.nextDouble(); 
		}
		return values;
	}	

	public static void main(String[] args)
	{
		String[] fileNames = {"badData.txt", "data.txt", "missingData.txt"};
		for (int i = 0; i < fileNames.length; i++) 
		{
			try 
			{
				double[] data = readFile(fileNames[i]);
				double sum = 0;
				for (double d : data) 
				{
					sum = sum + d;
				} 
				System.out.println("Sum: " + sum);
			}
			//$start catch exceptions FileNotFoundException, NoSuchElementException, IOException
			// For FileNotFoundException, print "File not found: " followed by the message stored in the exception object
			catch (FileNotFoundException e)
			{
				System.out.println("File not found: " + e.getMessage());
				//System.exit(0);
			}
			// For NoSuchElementException, print "File contents contain bad data"
			catch (NoSuchElementException e)
			{
				System.out.println("File contents contain bad data");
			}
			// For IOException print out the message stored in the exception object (Hint: use the getMessage() method)
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
			//$end
		}
		System.out.println("Expected:");
		System.out.println("File contents contain bad data");
		System.out.println("File not found: data.txt (The system cannot find the file specified)");
		System.out.println("File contents contain bad data");
	}
}