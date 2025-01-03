/**
   A automobile has a fuel level and an efficiency

   P3.7.  	

   Modify the given class Automobile so that it has the following properties. An
   automobile has a certain fuel efficiency (measured in km/liters) and a certain
   amount of fuel in the gas tank. The efficiency is initialized in the
   constructor method via the parameter, and the initial fuel level is 0. Supply a method called drive
   that simulates driving the automobile for a certain distance, reducing the
   amount of gasoline in the fuel tank. Also supply methods getGasInTank,
   returning the current amount of gasoline in the fuel tank, and addGas,
   to add gasoline to the fuel tank. 
   Look at the tester code (AutomobileTester.java) for help in understanding these methods
   
   Difficulty: Easy
 */
public class Automobile
{  
	private double efficiency ; // kilometers per liter
	private double fuel ; // amount of gas in the tank
	/**
       Initialize inastance variables zero fuel and the given efficiency kmPerLiter
       @param kmPerLiter
	 */
	public Automobile(double kmPerLiter)
	{   
		//$start set the instance variable fuel to zero; 
		fuel = 0;
		//2. set efficiency to the parameter value
		efficiency = kmPerLiter ;
		//$end
	}

	/**
       Drives the automobile the given distance
       @param distance
	 */
	public void drive(double distance)
	{  
		//$start 1. calculate the gas used in going that distance 
		// i.e. divide distance by efficiency, update fuel accordingly
		double gasUsed = distance / efficiency ;
		//2. update the fuel instance variable (fule should decrease)
		fuel = fuel - gasUsed ;
		//$end
	}

	/**
       Puts fuel in the automobile.
       @param amount the amount of gas added
	 */
	public void addGas(double amount)
	{   
		//$start update the fuel variable
		fuel = fuel + amount ;
		//$end
	}

	/**
       Gets the current fuel level of the automobile.
       @return the current fuel level
	 */
	public double getGasInTank()
	{   
		//$start return the current fuel level
		return fuel;
		//$end
	}
}



