public class PersonTester 
{
  public static void main(String[] args)
  {
	  
	  Person p1 = new Person("Tom","O'Brien");
	  Person p2 = new Person("Alireza","Sadeghian");
	  Person p3 = new Person("Timothy","O'Brien");
	  
	  // Expected output:
	  // Name = Tom O'Brien
	  // Initials = TO
      // Name = Alireza Sadeghian
      // Initials = AS
	  System.out.println("Name = " + p1.getFullName());
	  System.out.println("Initials = " + p1.getInitials());
	  
	  System.out.println("Name = " + p2.getFullName());
	  System.out.println("Initials = " + p2.getInitials());
	  System.out.println("Expected:\nName = Tom O'Brien\nInitials = TO\nName = Alireza Sadeghian\nInitials = AS");
	  
	  if (p1.equals(p2))
	  	System.out.println(p1.getFullName() + " has the same family name as " + p2.getFullName());
	  else
	  	System.out.println(p1.getFullName() + " does not have the same family name as " + p2.getFullName());
	  System.out.println("Expected:\nTom O'Brien does not have the same family name as Alireza Sadeghian");
	  if (p1.equals(p3))
	  	System.out.println(p1.getFullName() + " has the same family name as " + p3.getFullName());
	  else
	  	System.out.println(p1.getFullName() + " does not have the same family name as " + p3.getFullName());
	  System.out.println("Expected:\nTom O'Brien has the same family name as Timothy O'Brien");
  }
}
