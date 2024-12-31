import java.util.List;
import java.util.ArrayList;

/*
 * 
 *  This program loops through an array list of strings and finds the longest string
 */
public class FindLongest
{
	  /*
	   * Given the array list of strings, return the longest string
	   */
    public static String findLongest(ArrayList<String> list)
    {
    		//$start loop through the list of strings and check to see if 
    	  // the string length is > the current longest string. If so, update the
    	  // longest string length. Be sure to create a variable to hold the longest string itself
    	  // as well as the length
    	  String result = "";
    	  int maxLength = 0;
        for (int i = 0; i < list.size(); i++)
        {
        	
        	String word = list.get(i);
        	 if (word.length() > maxLength)
        	 {
        		 maxLength = word.length();
        		 result = word;
        	 }
        }
        return result;
        //$end
    }

    public static void main(String[] args)
    {
        ArrayList<String> elems = new ArrayList<String>();
        String[] words = {"singapore", "cattle", "metropolitan", "turnstile", "city", "deviation"};
        for (int i = 0; i < words.length; i ++)
        {
            elems.add(words[i]);
        }
        System.out.println(findLongest(elems));
        System.out.println("Expected:\nmetropolitan");
        elems.clear();
        System.out.println(findLongest(elems));
        System.out.println("Expected:\n");
    }
}
