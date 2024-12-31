public class Soda
{
	/**
	 * name: name of the Soda
	 * sugar: number of grams of sugar in volume
	 * volume: volume of container
	 */
	String name;
	int sugar;
	int volume;


	/**
      Create a constructor method with 3 parameters to initialize 
      the 3 instance variables (see SodaTester.java as a guide)
	 */
	//$start
	public Soda(String name, int sugar, int volume)
	{
		this.name = name;
		this.sugar = sugar;
		this.volume = volume;
	}
	//$end



	/**
      Create a public method getSugar() that returns the amount of sugar
	 */
	//$start
	public int getSugar()
	{
		return sugar;
	}
	//$end



	/**
	 * Create a method: public String compareSugar(Soda other)
	 * 
	 * This method compares the amount of sugar in the this Soda object
	 * (e.g. this.sugar) with the amount of sugar in the other Soda object
	 * (e.g. other.getSugar() or other.sugar)
	 * 
	 * If amount of sugar in the this object is greater than the amount in other
	 * return the String containing:
	 * name of this soda followed by " is sweeter than " followed by the name
	 * of the other soda
	 * 
	 * If amount of sugar in the other Soda object is greater than the amount in
	 * the this object, return the String containing:
	 * name of other soda followed by " is sweeter than " followed by the name
	 * of the this soda 
	 * 
	 * If amount of sugar in the this Soda object is the same as the amount in
	 * the other object, return the String containing:
	 * name of this soda followed by " has the same sweetness as " followed by the name
	 * of the other soda 
	 * 
	 */
	//$start
	public String compareSugar(Soda other)
	{
		if (this.sugar > other.sugar)
			return this.name + " is sweeter than " + other.name;
		else if (this.sugar < other.sugar)
			return other.name + " is sweeter than " + this.name;
		else
			return this.name + " has the same sweetness as " + other.name;
	}
	//$end
}
