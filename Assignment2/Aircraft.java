/*
 * 
 * This class models an aircraft type with a model name, a maximum number of economy seats, and a max number of forst class seats 
 * 
 * Add code such that class Aircraft implements the Comparable interface
 * Compare two Aircraft objects by first comparing the number of economy seats. If the number is equal, then compare the
 * number of first class seats 
 */
public class Aircraft implements Comparable<Aircraft> 
{
    int numEconomySeats;
    int numFirstClassSeats;

    String model;
    String[][] seatLayout;

    private int rows;
    private int cols;

    public Aircraft(int seats, String model) 
    {
        this.numEconomySeats = seats;
        this.numFirstClassSeats = 0;
        this.model = model;
        setSeat();
    }

    public Aircraft(int economy, int firstClass, String model) 
    {
        this.numEconomySeats = economy;
        this.numFirstClassSeats = firstClass;
        this.model = model;
        setSeat();
    }

    public void setRows(int rows) 
    {
        this.rows = rows;
    }

    public void setCols(int cols) 
    {
        this.cols = cols;
    }

    public int getCols() 
    {
        return cols;
    }

    public int getRows() 
    {
        return rows;
    }

    private void setSeat() 
    {
        if (numEconomySeats <= 4) 
        {
            rows = 2;
            cols = 2;
        } 
        else 
        {
            rows = 4;
            cols = numEconomySeats/rows;
        }
        seatLayout = new String[rows][cols];
    }

    public int getNumSeats() 
    {
        return numEconomySeats;
    }

    public int getTotalSeats() 
    {
        return numEconomySeats + numFirstClassSeats;
    }

    public int getNumFirstClassSeats() 
    {
        return numFirstClassSeats;
    }

    public String getModel() 
    {
        return model;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public void print() 
    {
        System.out.println("Model: " + model + "\t Economy Seats: " + numEconomySeats + "\t First Class Seats: " + numFirstClassSeats);
    }

    /*
     * Write a compareTo method that is part of the Comparable interface
     */
    @Override
    public int compareTo(Aircraft aircraft) 
    {
        if (this.numEconomySeats == aircraft.numEconomySeats)
        {
            return this.numFirstClassSeats - aircraft.numFirstClassSeats; 
        }
        return this.numEconomySeats - aircraft.numEconomySeats;
    }
}

