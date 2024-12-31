import java.util.ArrayList;

/**
   A class that keeps track of a dynamic menu.
 */
public class Menu
{
	private ArrayList<String> menuItems;


	/**
      Constructs a menu with no options.
	 */
	public Menu()
	{
		//$start initialize menuItems to an empty array list of Strings
		menuItems = new ArrayList<String>();
		//$end
	}

	/**
      Adds a new menu item to the end of this menu.
      @param item the menu item to add
	 */
	public void addOption(String item)
	{
		//$start simply add the given item to the end of the array list
		menuItems.add(item);
		//$end
	}

	/**
      Displays the menu, with options numbered starting with 1. (i.e. not 0)

      @return the number that the user supplied
	 */
	public void print()
	{
		//$start for each item in the menu, print the menu item number (add 1 to the item number index in the array list) 
		// followed by a ". " followed by the item name. 
		for (int i = 0; i < menuItems.size(); i++)
		{
			int itemNum = i+1;
			System.out.println(itemNum + ". " + menuItems.get(i)); 
		}
		//$end
	}

	public String getOption(int itemNum)
	{
		//$start given an item number (indexed from 1) if it is a valid item number,
		// return the item in the menu corresponding to this item number.
		// If the item number is not valid, return a ""
		if (itemNum >= 1 && itemNum <= menuItems.size())
			return menuItems.get(itemNum-1);

		return "";
		//$end
	}
}
