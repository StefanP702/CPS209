import java.util.Objects;

enum CrewTitle {PILOT, NAVIGATOR, ATTENDANT};

public class CrewMember extends Person 
{
    CrewTitle title;
    public CrewMember(String name, String title) 
    {
        super(name);
        if (title.equalsIgnoreCase("PILOT"))
        {
            this.title = CrewTitle.PILOT; 
        }
        else if (title.equalsIgnoreCase("NAVIGATOR"))
        {
            this.title = CrewTitle.NAVIGATOR; 
        }
        else if (title.equalsIgnoreCase("ATTENDANT"))
        {
            this.title = CrewTitle.ATTENDANT; 
        }
    }

    public CrewMember(String name, CrewTitle pilot) 
    {
        super(name);
        this.title = pilot;
    }

    public CrewTitle getTitle() 
    {
        return title;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (this == o) 
        {
         return true; 
        }
        
        if (o == null || getClass() != o.getClass())  
        {
          return false; 
        }
        CrewMember that = (CrewMember) o;
        return name.equals(((CrewMember) o).getName()) && title == that.title;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(title);
    }

    public void print() 
    {
        System.out.println(name + " " + title);
    }
}
