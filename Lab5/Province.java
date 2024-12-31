public class Province
{
   
    String name;
    int population;
    double area;
   
   /**
      Create a constructor method that has 3 parameters,
      one to initialize the name, one to initialize the 
      population and one to initialize the area 
   */
   //$start
    public Province(String name, int population, double area)
    {
    	this.name = name;
    	this.population = population;
    	this.area = area;
    }
    //$end
   
     
   /**
      Create a public method called getProvinceStats() that returns a String
      containing the name of the province followed by " Population: " followed by
      the population followed by " Area: " followed by the area
   */
   //$start
   public String getProvinceStats()
   {
  	 return name + " Population: " + population + " Area: " + area;
   }
   //$end
   
   
   
   /**
      Create a public method getPopulationDensity() that returns a double
      number representing the population density. 
   */
   //$start
   public double getPopulationDensity()
   {
  	 return population/area;
   }
   //$end
   
   // Create a public method int compareDensity(Province other) that returns 
   // +1 if the this province density is > than the other province density
   // -1 if the this province density is < than the other province density
   // 0 if the densities are the same
   //$start
   public int compareDensity(Province other)
   {
  	 if (this.getPopulationDensity() > other.getPopulationDensity()) return 1;
  	 else if (this.getPopulationDensity() < other.getPopulationDensity()) return -1;
  	 else return 0;
   }
   //$end
}
