
/**
   A class representing an instructor.
*/
public class Instructor extends SchoolPerson
{
   private int salary;

   /**
      Create an instructor with a given name and date of birth and salary.
      @param name the name
      @param yearOfBirth the date of birth
      @param salary the salary
   */
   public Instructor(String name, int yearOfBirth, int sal)
   {
  	//$start Initialize the inherited variables using super() and initialize
 	  // the new variable salary
      super(name, yearOfBirth);
      this.salary = sal;
      //$end
   }

   /**
      Convert instructor to string form.
   */
   public String toString()
   {
  	//$start override the method toString() and return a string
 	  // containing the values of the inherited variables followed by
 	  // " Salary: " followed by salary. Hint: make use of super. 
      return super.toString() + " Salary: " + salary;
	  //$end
   }
}

