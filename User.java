import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private ArrayList<Flight> flights = new ArrayList<Flight>();
    public static Scanner sc = new Scanner(System.in);
    private ArrayList<String> bookedTicket = new ArrayList<String>();
    private int charge = 0;
    public User(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void changePassword(){
        System.out.println("Enter your new password: ");
        setPassword(sc.next());
        return;
    }
    public void searchFlightsTickets(){
        System.out.println("<1>Based on flight id\n<2> Based on origin\n<3> Based on destination\n<4> Based on date\n" +
                "<5> Based on time\n<6> Based on price\n<7> Based on seats\n<-1> Return\n");
        int command = sc.nextInt();
        String compare = new String();
        int compareInt;
        while(command != -1){
            switch(command){
                case 1:
                    System.out.print("\nFlight id: ");
                    compare = sc.next();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compare.equals(flights.get(i).getFlightId()))
                        {
                            showFlight(i);
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("\nOrigin: ");
                    compare = sc.next();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compare.equals(flights.get(i).getOrigin()))
                        {
                            showFlight(i);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("\nDestination: ");
                    compare = sc.next();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compare.equals(flights.get(i).getDestination()))
                        {
                            showFlight(i);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("\nDate: ");
                    compare = sc.next();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compare.equals(flights.get(i).getDate()))
                        {
                            showFlight(i);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("\nTime: ");
                    compare = sc.next();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compare.equals(flights.get(i).getTime()))
                        {
                            showFlight(i);
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.print("\nPrice: ");
                    compareInt = sc.nextInt();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compareInt == flights.get(i).getPrice())
                        {
                            showFlight(i);
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.print("\nSeats: ");
                    compareInt = sc.nextInt();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compareInt == flights.get(i).getSeats())
                        {
                            showFlight(i);
                            break;
                        }
                    }
                    break;
            }
            deleteScreen();
            System.out.println("<1>Based on flight id\n<2> Based on origin\n<3> Based on destination\n<4> Based on date\n" +
                    "<5> Based on time\n<6> Based on price\n<7> Based on seats\n<-1> Return\n");
            command = sc.nextInt();
        }
        return;
    }
    public void bookingTicket(){
        String flightId = new String();
        System.out.println("Enter flight id: ");
        flightId = sc.next();
        for (int i = 0; i < flights.size(); i++) {
            if(flightId.equals(flights.get(i).getFlightId())){
                flights.get(i).setSeats(flights.get(i).getSeats() - 1);
                flightId += "@";
                flightId += Integer.toString(flights.get(i).getSeats());
                System.out.println(flightId.length());
                System.out.println(flightId);
                bookedTicket.add(flightId);
                charge -= flights.get(i).getPrice();
                break;
            }
        }
    }
    public void ticketCancellation(){
        System.out.println("Enter your ticket id: ");
        String ticketId = sc.next();
        String tmp = new String();
        int i = 0;
        while(ticketId.charAt(i) != '@'){
            tmp += ticketId.charAt(i);
            i++;
        }
        for (int j = 0; j < bookedTicket.size(); j++) {
            if(bookedTicket.get(j) == ticketId){
                bookedTicket.remove(j);
                break;
            }
        }
        for (int j = 0; j < flights.size(); j++) {
            if(flights.get(j).getFlightId().equals(tmp)){
                charge += flights.get(j).getPrice();
                break;
            }
        }
    }
    public void bookedTickets(){
        for (String bT : bookedTicket) {
            System.out.println(bT);
        }
    }
    public void addCharge(){
        System.out.println("Your charge is: " + charge + "\nEnter the charge you want to add: ");
        charge += sc.nextInt();
    }
    public void showFlight(int i){
        System.out.println("|FlightId\t\t\t|Origin\t\t\t\t|Destination\t\t\t|Date\t\t\t\t|Time\t\t\t|Price\t\t\t|Seats|");
        System.out.println("................................................................................................");
        System.out.printf("|%s\t\t\t\t|%s\t\t\t\t|%s\t\t\t\t\t|%s\t\t\t\t|%s\t\t\t\t|%d\t\t\t\t|%d|%n", flights.get(i).getFlightId(), 
                flights.get(i).getOrigin(), flights.get(i).getDestination(), flights.get(i).getDate(),
                flights.get(i).getTime(), flights.get(i).getPrice(), flights.get(i).getSeats());
    }
    public static void deleteScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
