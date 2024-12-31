import java.util.Scanner;
/*
 * This program determines the positions of vowel within a word
 * For example, if the word = "hello" then the vowels are at positions 1 and 4
 *              if the word = "allocate" then the vowels are at positions 0 3 5 7
 */
public class VowelPositions 
{
   public static void main(String[] args) 
   {
  	  String  words = "abdicate kite quick zap zz mood about cattle"; 
      Scanner in = new Scanner(words);
     
      while (in.hasNext())
  	  {
  	  	String word = in.next();
        System.out.print("Word: " + word + " Vowels in positions: ");
        //$start Use a for loop and go through each character of the strong word
        // check if the character is 'a' 'A' 'e' 'E' 'i' 'I' 'o' 'O' 'u' 'U'
        // if so, print the position in the string word
        for (int n = 0; n < word.length(); n++) 
        {
           // Check each letter of word to see if a vowel, 
           // and print its position. Hint: when comparing char don't forget to use == not =
        	 // Hint: use class String method charAt() to get the next character (pass the method an integer number.
        	//  e.g. word.charAt(3) returns a char at position 3
           char ch = word.charAt(n);
           if (ch == 'a' || ch == 'A'
            || ch == 'e' || ch == 'E'
            || ch == 'i' || ch == 'I'
            || ch == 'o' || ch == 'O'
            || ch == 'u' || ch == 'U') 
           {
            System.out.print(n + " ");
           }
        }
        //$end
        System.out.println();
  	  }
      System.out.println("Expected:");
      System.out.println("Word: abdicate Vowels in positions: 0 3 5 7"); 
      System.out.println("Word: kite Vowels in positions: 1 3");
      System.out.println("Word: quick Vowels in positions: 1 2"); 
      System.out.println("Word: zap Vowels in positions: 1"); 
      System.out.println("Word: zz Vowels in positions: "); 
      System.out.println("Word: mood Vowels in positions: 1 2"); 
      System.out.println("Word: about Vowels in positions: 0 2 3"); 
      System.out.println("Word: cattle Vowels in positions: 1 5"); 
   }
}