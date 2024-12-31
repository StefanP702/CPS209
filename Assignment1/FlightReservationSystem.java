import java.util.ArrayList;
import java.util.Scanner;

// Flight System for one single day at YYZ (Print this in title) Departing flights!!

public class FlightReservationSystem 
{
    public static void main(String[] args) 
    {
        // Create a FlightManager object
        FlightManager manager = new FlightManager();

        // List of reservations that have been made
        ArrayList<Reservation> myReservations = new ArrayList<Reservation>();// my flight reservations

        Scanner scanner = new Scanner(System.in);
        System.out.print(">");

        while (scanner.hasNextLine()) 
        {
            String inputLine = scanner.nextLine();
            if (inputLine == null || inputLine.equals("")) continue;

            // The command line is a scanner that scans the inputLine string
            // For example: list AC201
            Scanner commandLine = new Scanner(inputLine);

            // The action string is the command to be performed (e.g. list, cancel etc)
            String action = commandLine.next();

            if (action == null || action.equals("")) continue;

            if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
                return;

            // List all flights
            else if (action.equalsIgnoreCase("LIST")) 
            {
                manager.printAllFlights();
            }
            // Reserve a flight based on Flight number string (example input: res AC220)
            else if (action.equalsIgnoreCase("RES")) 
            {
                if (commandLine.hasNext()) 
                {
                    String fnum = commandLine.next();
                    try 
                    {
                        Reservation reservation = manager.reserveSeatOnFlight(fnum, "Economy Seat");
                        myReservations.add(reservation);
                        reservation.print();
                    } catch (FlightNotFoundException | FlightFullException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
            // Reserve a first class seat on a flight based on Flight number string (example input: res AC220)
            else if (action.equalsIgnoreCase("RESFCL")) 
            {
                if (commandLine.hasNext()) 
                {
                    String fnum = commandLine.next();
                    try 
                    {
                        Reservation reservation = manager.reserveSeatOnFlight(fnum, LongHaulFlight.firstClass);
                        myReservations.add(reservation);
                        reservation.print();
                    } 
                    catch 
                    (FlightNotFoundException | FlightFullException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
            // Query the flight manager to see if seats are still available for a specific flight (example input: seats AC220)
            // This one is done for you as a guide for other commands
            else if (action.equalsIgnoreCase("SEATS")) 
            {
                String flightNum = null;
                if (commandLine.hasNext()) 
                {
                    flightNum = commandLine.next();
                    try 
                    {
                        if (manager.seatsAvailable(flightNum)) 
                        {
                            System.out.println("Seats are available");
                        }
                    } 
                    catch 
                    (FlightNotFoundException | FlightFullException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
            // Cancel an existing reservation (example input: cancel AC220) 
            else if (action.equalsIgnoreCase("CANCEL")) 
            {
                if (commandLine.hasNext()) 
                {
                    String fnum = commandLine.next(); //fnum is flight number 
                    Reservation reservation = null;
                    for (Reservation r : myReservations) // assigned to variable r of myReservations arraylist 
                    {
                        if (r.getFlightNum().equals(fnum)) 
                        {
                            reservation = r;
                            break;
                        }
                    }
                    if (reservation != null) 
                    {
                        manager.cancelReservation(reservation);
                        myReservations.remove(reservation);
                    } 
                    else 
                    {
                        System.out.println("Flight " + fnum + " Not Found");
                    }
                }
            }
            // Reserve a flight based on Flight number string (example input: respsngr AC220 name passport)
            else if (action.equalsIgnoreCase("RESPSNGR")) 
            {
                if (commandLine.hasNext()) 
                {
                    String fnum = commandLine.next(); //fnum is flight number 
                    if (commandLine.hasNext()) {
                        String name = commandLine.next();
                        if (commandLine.hasNext()) 
                        {
                            String passport = commandLine.next();
                            try 
                            {
                                Reservation reservation = manager.reserveSeatOnFlight(fnum, name, passport, "Economy Seat");
                                myReservations.add(reservation);
                                reservation.print();
                            } 
                            catch (FlightNotFoundException | FlightFullException e) 
                            {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
            }
            // Cancel an existing reservation (example input: cnclpsngr AC220 name passport)
            else if (action.equalsIgnoreCase("CNCLPSNGR")) 
            {
                if (commandLine.hasNext()) 
                {
                    String fnum = commandLine.next();
                    if (commandLine.hasNext()) 
                    {
                        String name = commandLine.next();
                        if (commandLine.hasNext()) 
                        {
                            String passport = commandLine.next();
                            Reservation reservation = null;
                            for (Reservation r : myReservations)// assigned to variable r of myReservations arraylist 
                            {
                                if (r.getFlightNum().equals(fnum) && r.getPassenger().getName().equals(name) && r.getPassenger().getPassport().equals(passport)) {
                                    reservation = r;
                                    break;
                                }
                            }
                            if (reservation != null) 
                            {
                                manager.cancelReservation(reservation);
                                myReservations.remove(reservation);
                            } 
                            else 
                            {
                                System.out.println("Flight " + fnum + " Not Found");
                            }
                        }
                    }
                }
            }
            // Query the flight manager to see if seats are still available for a specific flight (example input: seats AC220)
            else if (action.equalsIgnoreCase("PSNGRS")) 
            {
                String flightNum = null;
                if (commandLine.hasNext()) 
                {
                    flightNum = commandLine.next();
                    try 
                    {
                        manager.printAllPassengers(flightNum);
                    } catch (FlightNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            // Print all the reservations in array list myReservations
            else if (action.equalsIgnoreCase("MYRES")) 
            {
                for (Reservation r : myReservations)
                {
                    r.print(); 
                }
            }
            // Print the list of aircraft (see class Manager)
            else if (action.equalsIgnoreCase("CRAFT")) 
            {
                manager.printAllAircraft();
            }
            else if (action.equalsIgnoreCase("SORTCRAFT")) 
            {
                manager.sortAircraft();
            } else if (action.equalsIgnoreCase("SORTBYDEP")) 
            {
                manager.sortByDeparture();
            } else if (action.equalsIgnoreCase("SORTBYDUR")) 
            {
                manager.sortByDuration();
            }
            System.out.print("\n>");
        }
    }
}
