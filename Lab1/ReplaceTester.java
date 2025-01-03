/**
   P2.12 Encodes a string by replacing all letters "i" with "!" and
   all letters "s" with "$". Use the replace method. Do this with
   variable town, assigning the result to variable townEncoding, and with the
   variable sentence, assigning the result to variable sentenceEncoding.
 */

public class ReplaceTester
{
    public static void main(String[] args)
    {
        String town = "Mississauga" ;
        String townEncoding ;
        String sentence = "This is a simple sentence." ;
	      String sentenceEncoding ;
	      //$start 1. Assign to townEncoding the result of applying the replace method to town to replace "i" with "!" ; 
        townEncoding = town.replace("i", "!") ;
	      //2. now replace s to $ in string townEncoding ; 
        townEncoding = townEncoding.replace("s", "$") ;
	      //3. assign to sentenceEncoding the result of applying replace() on sentence to replace "i" with "!".  
        sentenceEncoding = sentence.replace("i", "!") ;
	      //4. now replace s with $ in string sentenceEncoding.
        sentenceEncoding = sentenceEncoding.replace("s", "$") ;
	      //$end
	      System.out.println("Encoding of town:" + townEncoding) ;
	      System.out.println("Encoding of sentence:" + sentenceEncoding) ;
        System.out.println("Expect:") ;
        System.out.println("Encoding of town: M!$$!$$auga" ) ;
	      System.out.println("Encoding of sentence: Th!$ !$ a $!mple $entence.") ;
    }
}
