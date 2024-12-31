import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Flight System for one single day at YYZ (Print this in title) Departing flights!!

public class FlightReservationSystem 
{
    public static void main(String[] args) 
    {
        // Create a FlightManager object
        try 
        {
            FlightManager manager = new FlightManager();
            // List of reservations that have been made
            ArrayList<Reservation> myReservations = new ArrayList<>();    // my flight reservations
            Scanner scanner = new Scanner(System.in);
            System.out.print(">");

            while (scanner.hasNextLine()) 
            {
                String inputLine = scanner.nextLine();
                if (inputLine == null || inputLine.equals("")) 
                {
                    continue; 
                }
                // The command line is a scanner that scans the inputLine string
                // For example: list AC201
                Scanner commandLine = new Scanner(inputLine);

                // The action string is the command to be performed (e.g. list, cancel etc)
                String action = commandLine.next();

                if (action == null || action.equals("")) 
                {
                    continue; 
                }

                if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
                    return;

                // List all flights
                else if (action.equalsIgnoreCase("LIST")) 
                {
                    manager.printAllFlights();
                }
                // Reserve a flight based on Flight number string (example input: res UA267 McInerney DD1234 7B )
                else if (action.equalsIgnoreCase("RES")) 
                {
                    if (commandLine.hasNext()) 
                    {
                        String fnum = commandLine.next();
                        try 
                        {
                            String passengerName = commandLine.next();
                            String passengerPassport = commandLine.next();
                            String seat = commandLine.next();

                            Reservation reservation = manager.reserveSeatOnFlight(fnum, passengerName, passengerPassport, seat);
                            myReservations.add(reservation);
                            reservation.print();
                        } 
                        catch (FlightNotFoundException | SeatOccupiedException | DuplicatePassengerException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                // Query the flight manager to see if seats are still available for a specific flight (example input: seats AC220)
                // This one is done for you as a guide for other commands
                else if (action.equalsIgnoreCase("SEATS")) 
                {
                    String flightNum;
                    if (commandLine.hasNext()) 
                    {
                        flightNum = commandLine.next();
                        try 
                        {
                            manager.printSeats(flightNum);
                        } 
                        catch (FlightNotFoundException e) 
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
                        String fnum = commandLine.next();
                        String pname = commandLine.next();
                        String ppass = commandLine.next();
                        try 
                        {
                            Reservation reservation = null;
                            Passenger p = new Passenger(pname, ppass, "", "");
                            Reservation foundRes = new Reservation(fnum, "", p);

                            for (Reservation r : myReservations) 
                            {
                                if (r.equals(foundRes)) 
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
                                throw new PassengerNotInManifestException(p);
                            }
                        } 
                        catch (FlightNotFoundException | PassengerNotInManifestException e) 
                        {
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
                else if (action.equalsIgnoreCase("PASMAN")) 
                {
                    String fnum = commandLine.next();
                    try 
                    {
                        manager.printAllPassengers(fnum);
                    } 
                    catch (FlightNotFoundException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                } 
                else if (action.equalsIgnoreCase("PREBOARD")) 
                {
                    String flightNum = commandLine.next();
                    try 
                    {
                        manager.createPreboardQueue(flightNum);
                    } 
                    catch (FlightNotFoundException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                } 
                else if (action.equalsIgnoreCase("QUEUE")) 
                {
                    String flightNum = commandLine.next();
                    try 
                    {
                        manager.printQueue(flightNum);
                    } 
                    catch (FlightNotFoundException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                } 
                else if 
                (action.equalsIgnoreCase("BOARD")) 
                {
                    String flightNum = commandLine.next();
                    int startRow = commandLine.nextInt();
                    int endRow = commandLine.nextInt();
                    try 
                    {
                        manager.boardQueue(flightNum, startRow, endRow);
                    } 
                    catch (FlightNotFoundException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                } 
                else if (action.equalsIgnoreCase("CREWS")) 
                {
                    manager.printCrews();
                } 
                else if (action.equalsIgnoreCase("CREWFLI")) 
                {
                    String flightNum = commandLine.next();
                    try {
                        manager.printCrews(flightNum);
                    } catch (FlightNotFoundException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                }
                else if (action.equalsIgnoreCase("ADDCREW")) 
                {
                    String flightNum = commandLine.next();
                    String name = commandLine.next();
                    String title = commandLine.next();
                    try 
                    {
                        manager.addCrew(flightNum, new CrewMember(name, title));
                    } 
                    catch (FlightNotFoundException | DuplicateCrewException | CrewOccupiedException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                } 
                else if (action.equalsIgnoreCase("REMCREW")) 
                {
                    String flightNum = commandLine.next();
                    String name = commandLine.next();
                    String title = commandLine.next();
                    try 
                    {
                        manager.removeCrew(flightNum, new CrewMember(name, title));
                    } 
                    catch (FlightNotFoundException | CrewNotInFlightException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.print("\n>");
            }
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
