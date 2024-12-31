import java.util.ArrayList;

public class Letter
{
    String sender, recipient;
    ArrayList<String> lines;	// The actual contents of the letter, each line stored individually
    int numLines;             // number of lines in the letter
      
   /**
      Create a constructor method with 2 parameters, each of type String, one to initialize the
      sender and one to initialize the recipient. 
      initialize lines to a new array list, initially empty
   */
   //$start
    public Letter(String sender, String recipient)
    {
    	this.sender = sender;
    	this.recipient = recipient;
    	lines = new ArrayList<String>();
    }
    //$end
      
   /**
      Create a public method void addLine(String line) that adds a new line to the letter.
      i.e. adds the new line to the array list
   */
    //$start
   public void addLine(String line)
   {
  	 lines.add(line);
   }
   //$end
     
   /**
      Create a public method String getText() that returns a String containing:
      "Dear " followed by the recipient name followed by ":\n\n" followed
      by the text of the letter followed by "\nSincerely,\n" followed by the
      sender name. Add a "\n" to the end of each line in array list lines 
   */
   //$start
   public String getText()
   {
  	 String opening = "Dear " + recipient + ":\n\n";
  	 String closing = "\nSincerely,\n" + sender;
  	 String body = "";
  	 for (int i = 0; i < lines.size(); i++)
  	 {
  		 body += lines.get(i) + "\n";
  	 }
  	 return opening + body + closing;
   }
   //$end
   
   
   
   /**
    * Create a public method getNumberOfLines() that returns the number of lines that were explicitly added to the letter
    * using the addLines() method
    */
   //$start
   public int getNumberOfLines()
   {
  	 return lines.size();
   }
   //$end
   
   // Create a public method void removeLine(int index) that removes a line from the array list at location index.
   // Make sure to subtract 1 from the parameter variable index before removing the line from arrayList lines.
   // Make sure that index-1 is in the range 0 to lines.size()-1 
   // If it is not in this range, do nothing.
   //$start
   public void removeLine(int index)
   {
  	 if (index-1 < 0 || index-1 >= lines.size()) return;
  	 
  	 lines.remove(index-1);
   }
   //$end
   
  
}
