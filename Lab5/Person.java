public class Person
{
   String firstName;
   String familyName;
   
   // Create a Constructor Method with two arguments to set the
   // firstName and familyName instance variables 
   //$start
   public Person(String first, String fam)
   {
  	 firstName = first;
  	 familyName = fam;
   }
   //$end
   
      
   // Create a public method called getFullName() that returns a string containing
   // the first name followed by a blank space followed by the family name
   //$start
   public String getFullName()
   {
  	 return firstName + " " + familyName;
   }
   //$end
   
   
   
   // Create a public method call getInitials() that returns a string containing the
   // first letter of the first name followed by the first letter of 
   // the family name. Hint: use the substring method of class String. 
   //$start
   public String getInitials()
   {
  	 return firstName.substring(0,1) + familyName.substring(0,1);
   }
   //$end
   
   
   // Create a method boolean equals(Object other) - **using this exact method signature!!** -
   // this method will compare the family name of the this Person object to the other object
   // and return true if they are equal, false otherwise
   // Hint: 1) first create a reference variable Person otherP and set it equal to the parameter
   // variable other: Person otherP = (Person) other;
   // then use variable otherP to test for equality of family names 
   // 2) Don't forget you must use the equals method of class String when comparing familyName strings
   // That means that the equals method of class Person will be calling the equals method of class String using
   // the familyName variable but these are two different equals methods!!  
   //$start
   public boolean equals(Object other)
   {
  	 Person otherP = (Person) other;
  	 return this.familyName.equals(otherP.familyName);
   }
   //$end
}
