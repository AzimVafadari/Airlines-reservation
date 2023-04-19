import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private ArrayList<Flight> flights = new ArrayList<Flight>();
    private ArrayList<String> cancelledTickets = new ArrayList<>();
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
        System.out.println("\033[38;2;130;255;130mEnter your new password: \033[38;2;0;255;0m");
        setPassword(sc.next());
        System.out.println("\033[0m");
        return;
    }
    public void searchFlightsTickets(){
        System.out.println("\033[38;2;255;255;200m<\033[38;2;255;255;0m1\033[38;2;255;255;200m> Based on flight id\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m2\033[38;2;255;255;200m> Based on origin\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m3\033[38;2;255;255;200m> Based on destination\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m4\033[38;2;255;255;200m> Based on date\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m5\033[38;2;255;255;200m> Based on time\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m6\033[38;2;255;255;200m> Based on price\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m7\033[38;2;255;255;200m> Based on seats\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m-1\033[38;2;255;255;200m> Return\n");
        int command = sc.nextInt();
        deleteScreen();
        String compare = new String();
        int compareInt;
        while(command != -1){
            switch(command){
                case 1:
                    System.out.print("\nFlight id: ");
                    compare = sc.next();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compare.equals(flights.get(i).getFlightId()))
                            showFlight(i);
                    }
                    break;
                case 2:
                    System.out.print("\nOrigin: ");
                    compare = sc.next();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compare.equals(flights.get(i).getOrigin()))
                            showFlight(i);
                    }
                    break;
                case 3:
                    System.out.print("\nDestination: ");
                    compare = sc.next();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compare.equals(flights.get(i).getDestination()))
                            showFlight(i);
                    }
                    break;
                case 4:
                    System.out.print("\nDate: ");
                    compare = sc.next();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compare.equals(flights.get(i).getDate()))
                            showFlight(i);
                    }
                    break;
                case 5:
                    System.out.print("\nTime: ");
                    compare = sc.next();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compare.equals(flights.get(i).getTime()))
                            showFlight(i);
                    }
                    break;
                case 6:
                    System.out.print("\nPrice: ");
                    compareInt = sc.nextInt();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compareInt == flights.get(i).getPrice())
                            showFlight(i);
                    }
                    break;
                case 7:
                    System.out.print("\nSeats: ");
                    compareInt = sc.nextInt();
                    for (int i = 0; i < flights.size(); i++) {
                        if(compareInt == flights.get(i).getSeats())
                            showFlight(i);
                    }
                    break;
            }
            sc.nextLine();
            deleteScreen();
            System.out.println("\033[38;2;255;255;200m<\033[38;2;255;255;0m1\033[38;2;255;255;200m> Based on flight id\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m2\033[38;2;255;255;200m> Based on origin\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m3\033[38;2;255;255;200m> Based on destination\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m4\033[38;2;255;255;200m> Based on date\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m5\033[38;2;255;255;200m> Based on time\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m6\033[38;2;255;255;200m> Based on price\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m7\033[38;2;255;255;200m> Based on seats\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m-1\033[38;2;255;255;200m> Return\n");
            command = sc.nextInt();
        }
        return;
    }
    public void bookingTicket(){
        String flightId = new String();
        System.out.println("\033[38;2;130;255;130mEnter flight id: \033[0m");
        flightId = sc.next();
        for (int i = 0; i < cancelledTickets.size(); i++) {
            String tmp = new String();
            int j = 0;
            while(cancelledTickets.get(i).charAt(j) != '@'){
                tmp += cancelledTickets.get(i).charAt(j);
                j++;
            }
            if(tmp.equals(flightId)){
                flightId = cancelledTickets.get(i);
                cancelledTickets.remove(i);
                return;
            }
        }
        for (int i = 0; i < flights.size(); i++) {
            if(flightId.equals(flights.get(i).getFlightId())){
                if(flights.get(i).getPrice() > charge){
                    System.out.println("\033[38;2;255;0;0mYour charge isn't enough go back and add charge \033[38;2;0;255;0m:)\033[0m");
                    sc.nextLine();
                    return;
                }
                flightId += "@";
                flightId += Integer.toString(flights.get(i).getSeats());
                flights.get(i).setSeats(flights.get(i).getSeats() - 1);
                System.out.println(flightId);
                bookedTicket.add(flightId);
                charge -= flights.get(i).getPrice();
                return;
            }
        }
    }
    //This part is ticket
    public void ticketCancellation(){
        System.out.println("\033[38;2;130;255;130mEnter your ticket id: \033[0m");
        String ticketId = sc.next();
        cancelledTickets.add(ticketId);
        String tmp = new String();
        int i = 0;
        while(ticketId.charAt(i) != '@'){
            tmp += ticketId.charAt(i);
            i++;
        }
        bookedTicket.remove(ticketId);
        for (int j = 0; j < flights.size(); j++) {
            if(flights.get(j).getFlightId().equals(tmp)){
                charge += flights.get(j).getPrice();
                flights.get(j).setSeats(flights.get(j).getSeats() + 1);
                break;
            }
        }
    }
    public void bookedTickets(){
        for (int i = 0; i < bookedTicket.size(); i++) {
            System.out.println("\033[38;2;0;0;255m" + bookedTicket.get(i));
        }
        sc.nextLine();
    }
    public void addCharge(){
        System.out.println("\033[38;2;0;255;0mYour charge is: " + charge + "\nEnter the charge you want to add: \033[38;2;255;255;0m");
        charge += sc.nextInt();
        System.out.println("\033[0m");
    }
    public void showFlight(int i){
        System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                "Seats\t\033[38;2;255;255;0m|\033[0m");
        System.out.println("\033[38;2;255;255;255m.........................................................................................................\033[0m");
        System.out.printf("\033[38;2;255;255;0m|\033[38;2;255;255;200m%1$-15s" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200m%2$-15s" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200m%3$-15s" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200m%4$-15s" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200m%5$-15s" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200m%6$-,15d" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200m%7$-7d" +
                        "\033[38;2;255;255;0m|%n\033[0m", flights.get(i).getFlightId(),
                flights.get(i).getOrigin(), flights.get(i).getDestination(), flights.get(i).getDate(),
                flights.get(i).getTime(), flights.get(i).getPrice(), flights.get(i).getSeats());
        sc.nextLine();
    }
    public static void deleteScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
