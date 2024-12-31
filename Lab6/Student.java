
/**
   A class representing a student.
*/
public class Student extends SchoolPerson
{
   private String major;

   /**
      Create a student with a given name and date of birth and major.
      @param name the name
      @param yearOfBirth the date of birth
      @param major the major
   */
   public Student(String name, int yearOfBirth, String maj)
   {
  	  //$start Initialize the inherited variables using super() and initialize
  	  // the new variable major
      super(name, yearOfBirth);
      this.major = maj;
      //$end
   }

   /**
      Convert student to string form
   */
   public String toString()
   {
  	  //$start override the method toString() and return a string
  	  // containing the values of the inherited variables followed by
  	  // " Major: " followed by major. Hint: make use of super.  
      return super.toString() + " Major: " + major;
      //$end
   }
}

