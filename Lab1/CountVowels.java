import java.util.Scanner;
/*
 * This program counts the number of vowels in a sentence where the string 
 * 
 * For example, if the sentence string is "hello how are you" the number of vowels is:
 * 
 * 7  (e, o, o, a, e, o, u)
 * 
 */
public class CountVowels
{
   public static void main(String[] args)
   {
      String sentence = "The quick brown fox jumps over the lazy dog";
      
      //$start Create an integer variable called vowelCount and initialize it to 0
      int vowelCount = 0;
      //$end
      
      //$start Write a for loop that counts from 0 to the length-1 of the string variable sentence (see above)
  	  // Inside the loop use the charAt() method of the String class and check if the current character of the sentence is a vowel.
      // If it is, increment vowelCount by 1
      // A vowel is defined as one of the following characters 'a' 'e' 'i' 'o' 'u' 'y' 'A' 'E' 'I' 'O' 'U' 'Y'
      for (int i = 0; i < sentence.length(); i++)
      {
         char currentCharacter = sentence.charAt(i);
         if (  currentCharacter == 'a' || currentCharacter == 'A'
            || currentCharacter == 'e' || currentCharacter == 'E'
            || currentCharacter == 'i' || currentCharacter == 'I'
            || currentCharacter == 'o' || currentCharacter == 'O'
            || currentCharacter == 'u' || currentCharacter == 'U'
			      || currentCharacter == 'y' || currentCharacter == 'Y')
         {
            vowelCount++;
         }
      }
      //$end 
      System.out.println("Vowel Count = " + vowelCount ) ;
      System.out.println("Expected: ") ;
      System.out.println("Vowel Count = " + 12) ;
     
   }
}
