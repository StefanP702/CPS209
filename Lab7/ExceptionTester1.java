import java.util.* ;
import java.io.* ;
/*
 * 
 * Simple program to test FileNotFoundException 
 */
public class ExceptionTester1
{
	public static void main(String[] args) 
	{
		//$start Use a try{...}catch(){..} block and open a file "input.txt" (use the File class)
		// read in one word from the file (use a Scanner) and print the length of the word
		// The file "input.txt" does not exist so you should catch FileNotFoundException and print:
		// "File not found"
		try
		{
			Scanner scanner = new Scanner(new File("input.txt")) ;
			String word = scanner.next() ;
			System.out.println("Length of your word: " + word.length()) ;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found") ;
		}
		//$end
		System.out.println("Expected:\nFile not found") ;
	}
}
