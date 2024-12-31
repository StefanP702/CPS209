
/**
   A class to model a manager.
 */
public class Manager extends Employee
{
	private String department;

	/**
      Make a manager with a given name, salary, and department.
      @param name the name
      @param salary the salary
      @param department the department
	 */
	public Manager(String name, double salary, String dept)
	{
		//$start Initialize the inherited variables name and salary using the super() keyword
		// initialize the new instance variable department
		super(name, salary);
		this.department = dept;
		//$end
	}

	/**
      Provide a string description of a manager.
	 */
	
	public String toString()
	{
	//$start Override the method toString() from super class Employee
		//Hint: use the super. (see toString() method in Employee)
		// and add " Department: " followed by the department name to the returned string
		return super.toString() + " Department: " + this.department;
	//$end
	}
	
}
