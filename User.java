import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class User {
    private String username;

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    private String password;
    private ArrayList<Flight> flights = new ArrayList<Flight>();
    private ArrayList<Flight> filteredFlights = new ArrayList<Flight>();
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
        //in this part it copies flights into filteredflights
        filteredFlights.addAll(flights);
//        for (int i = 0; i < flights.size(); i++) {
//            filteredFlights.get(i).setFlightId(flights.get(i).getFlightId());
//            filteredFlights.get(i).setOrigin(flights.get(i).getOrigin());
//            filteredFlights.get(i).setDestination(flights.get(i).getDestination());
//            filteredFlights.get(i).setDate(flights.get(i).getDate());
//            filteredFlights.get(i).setTime(flights.get(i).getTime());
//            filteredFlights.get(i).setPrice(flights.get(i).getPrice());
//            filteredFlights.get(i).setSeats(flights.get(i).getSeats());
//        }
        System.out.println("\033[38;2;255;255;200m<\033[38;2;255;255;0m1\033[38;2;255;255;200m> Based on flight id\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m2\033[38;2;255;255;200m> Based on origin\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m3\033[38;2;255;255;200m> Based on destination\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m4\033[38;2;255;255;200m> Based on date\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m5\033[38;2;255;255;200m> Based on time\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m6\033[38;2;255;255;200m> Based on price\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m7\033[38;2;255;255;200m> Based on seats\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m8\033[38;2;255;255;200m> Finally\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m-1\033[38;2;255;255;200m> Return\n");
        int command = sc.nextInt();
        String flightId = null;
        String origin = null;
        String destination = null;
        String date = null;
        String time = null;
        int lowPrice = 0;
        int highPrice = 0;
        String compare = new String();
        while(command != -1) {
            switch (command) {
                case 1:
                    System.out.print("\nFlight id: ");
                    flightId = sc.next();
                    System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Seats\t\033[38;2;255;255;0m|\033[0m");
                    for (int i = 0; i < filteredFlights.size(); i++) {
                        if (!flightId.equals(filteredFlights.get(i).getFlightId())) {
                            filteredFlights.remove(i);
                            i--;
                        }
                    }
                    showFilteredFlights();
                    break;
                case 2:
                    System.out.print("\nOrigin: ");
                    origin = sc.next();
                    System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Seats\t\033[38;2;255;255;0m|\033[0m");
                    for (int i = 0; i < filteredFlights.size(); i++) {
                        if (!origin.equals(filteredFlights.get(i).getOrigin())) {
                            filteredFlights.remove(i);
                            i--;
                        }
                    }
                    showFilteredFlights();
                    break;
                case 3:
                    System.out.print("\nDestination: ");
                    destination = sc.next();
                    System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Seats\t\033[38;2;255;255;0m|\033[0m");
                    for (int i = 0; i < filteredFlights.size(); i++) {
                        if (!destination.equals(filteredFlights.get(i).getDestination())) {
                            filteredFlights.remove(i);
                            i--;
                        }
                    }
                    showFilteredFlights();
                    break;
                case 4:
                    System.out.print("\nDate: ");
                    date = sc.next();
                    System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Seats\t\033[38;2;255;255;0m|\033[0m");
                    for (int i = 0; i < filteredFlights.size(); i++) {
                        if (!date.equals(filteredFlights.get(i).getDate())) {
                            filteredFlights.remove(filteredFlights.get(i));
                            i--;
                        }
                    }
                    showFilteredFlights();
                    break;
                case 5:
                    System.out.print("\nTime: ");
                    time = sc.next();
                    System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Seats\t\033[38;2;255;255;0m|\033[0m");
                    for (int i = 0; i < filteredFlights.size(); i++) {
                        if (!time.equals(filteredFlights.get(i).getTime())) {
                            filteredFlights.remove(i);
                            i--;
                        }
                    }
                    showFilteredFlights();
                    break;
                case 6:
                    System.out.print("\nPrice range from: ");
                    lowPrice = sc.nextInt();
                    System.out.print("\nto: ");
                    highPrice = sc.nextInt();
                    System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Seats\t\033[38;2;255;255;0m|\033[0m");
                    for (int i = 0; i < filteredFlights.size(); i++) {
                        if (lowPrice > filteredFlights.get(i).getPrice() || highPrice < filteredFlights.get(i).getPrice()) {
                            filteredFlights.remove(i);
                            i--;
                        }
                    }
                    showFilteredFlights();
                    break;
                case 7:
                    System.out.print("\nSeats: ");
                    int seats = sc.nextInt();
                    System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Seats\t\033[38;2;255;255;0m|\033[0m");
                    for (int i = 0; i < filteredFlights.size(); i++) {
                        if (seats != filteredFlights.get(i).getSeats()) {
                            showFlight(i);
                        }
                    }
                    break;
                case 8:
                    System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                            "Seats\t\033[38;2;255;255;0m|\033[0m");
                    showFilteredFlights();
                    break;
            }
            sc.nextLine();
            sc.nextLine();
            deleteScreen();
            System.out.println("\033[38;2;255;255;200m<\033[38;2;255;255;0m1\033[38;2;255;255;200m> Based on flight id\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m2\033[38;2;255;255;200m> Based on origin\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m3\033[38;2;255;255;200m> Based on destination\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m4\033[38;2;255;255;200m> Based on date\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m5\033[38;2;255;255;200m> Based on time\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m6\033[38;2;255;255;200m> Based on price\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m7\033[38;2;255;255;200m> Based on seats\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m8\033[38;2;255;255;200m> Finally\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m-1\033[38;2;255;255;200m> Return\n");
            command = sc.nextInt();
            deleteScreen();
        }
        return;
    }
    // This method show flights that is filtered by searching
    public void showFilteredFlights() {
        for (int i = 0; i < filteredFlights.size(); i++) {
            System.out.println("\033[38;2;255;255;255m.........................................................................................................\033[0m");
            System.out.printf("\033[38;2;255;255;0m|\033[38;2;255;255;200m%1$-15s" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200m%2$-15s" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200m%3$-15s" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200m%4$-15s" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200m%5$-15s" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200m%6$-,15d" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200m%7$-7d" +
                            "\033[38;2;255;255;0m|%n\033[0m", filteredFlights.get(i).getFlightId(),
                    filteredFlights.get(i).getOrigin(), filteredFlights.get(i).getDestination(), filteredFlights.get(i).getDate(),
                    filteredFlights.get(i).getTime(), filteredFlights.get(i).getPrice(), filteredFlights.get(i).getSeats());
        }
        return;
    }
    public void bookingTicket(){
        String flightId = new String();
        System.out.println("\033[38;2;130;255;130mEnter flight id: \033[0m");
        flightId = sc.next();
        for (int i = 0; i < flights.size(); i++) {
            if(flightId.equals(flights.get(i).getFlightId())){
                System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                        "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                        "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                        "Seats\t\033[38;2;255;255;0m|\033[0m");
                showFlight(i);
                if(flights.get(i).getPrice() > charge){
                    System.out.println("\033[38;2;255;0;0mYour charge isn't enough go back and add charge \033[38;2;0;255;0m:)\033[0m");
                    sc.nextLine();
                    return;
                }
                flightId += "@";
                flightId += Integer.toString(flights.get(i).getCntTickets());
                flights.get(i).setSeats(flights.get(i).getSeats() - 1);
                bookedTicket.add(flightId);
                charge -= flights.get(i).getPrice();
                flights.get(i).setCntTickets(flights.get(i).getCntTickets() + 1);
                Ticket ticket = new Ticket(this, flights.get(i), flightId);
                flights.get(i).tickets.add(ticket);
                return;
            }
        }
    }
    public void ticketCancellation(String ticketId){
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
                for (int k = 0; k < flights.get(j).tickets.size(); k++) {
                    if(flights.get(j).tickets.get(k).getTicketId().equals(ticketId)){
                        flights.get(j).tickets.remove(k);
                    }
                }
                break;
            }
        }
        return;
    }
    // booked ticket is based on flight id + @ + number of tickets for the flight
    public void bookedTickets(){
        if(bookedTicket.size()==0)
            System.out.println();
        System.out.println("\033[38;2;255;255;200mYour booked tickets is empty!");
        for (int i = 0; i < bookedTicket.size(); i++) {
            System.out.println("\033[38;2;0;0;220m" + bookedTicket.get(i));
        }
        sc.nextLine();
    }
    public void addCharge(){
        System.out.println("\033[38;2;0;255;0mYour charge is: " + charge + "\nEnter the charge you want to add: \033[38;2;255;255;0m");
        charge += sc.nextInt();
        System.out.println("\033[38;2;0;255;0mSuccesfully\nYour charge is:" + charge);
        System.out.println("\033[0m");
        sc.nextLine();
    }
    public void showFlight(int i){
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
    }
    public void deleteScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
