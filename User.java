import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class User {
    private String username;
    private String password;

    private int cursor;

    public User(int cursor){
        this.cursor = cursor;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    private ArrayList<Flight> filteredFlights = new ArrayList<Flight>();
    private Scanner sc = new Scanner(System.in);
    private int charge = 0;

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
        String newPassword = sc.next();
        try {
            int seekNow = 0;
            Data.passengers.seek(seekNow);
            for (int i = 0; i < Data.passengers.length()/64; i++) {
                if (username.equals(Data.readFixStringPassengers())){
                    Data.passengers.writeChars(newPassword);
                    break;
                }
                seekNow += 34;
                Data.passengers.seek(seekNow);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\033[0m");
        return;
    }
    public void searchFlightsTickets(){
        try {
            Data.flights.seek(0);
            //read flights from file and write into filteredFlight
            for (int i = 0; i < Data.flights.length()/158; i++) {
                Flight flight = new Flight(Data.readFixStringFlights(), Data.readFixStringFlights(),
                        Data.readFixStringFlights(), Data.readFixStringFlights(), Data.readFixStringFlights(), Data.flights.readInt(), Data.flights.readInt());
                filteredFlights.add(flight);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                        if (seats == filteredFlights.get(i).getSeats()) {
                            filteredFlights.remove(i);
                            i--;
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
    public void bookingTicket() throws IOException {
        System.out.println("\033[38;2;130;255;130mEnter flight id: \033[0m");
        String flightId = sc.next();
        int seekNow = 0;
        for (int i = 0; i < Data.flights.length()/158; i++) {
            Data.flights.seek(seekNow);
            if(flightId.equals(Data.readFixStringFlights())){
                Data.flights.seek(seekNow - 30);
                Flight flight = new Flight(Data.readFixStringFlights(), Data.readFixStringFlights(),
                        Data.readFixStringFlights(), Data.readFixStringFlights(), Data.readFixStringFlights(), Data.flights.readInt(), Data.flights.readInt());
                if(flight.getPrice() > charge){
                    System.out.println("\033[38;2;255;0;0mYour charge isn't enough go back and add charge \033[38;2;0;255;0m:)\033[0m");
                    sc.nextLine();
                    sc.nextLine();
                    return;
                }
                if(flight.getSeats() <= 0){
                    System.out.println("\033[38;2;255;0;0mYour flight is full!\033[38;2;0;255;0m:)\033[0m");
                    sc.nextLine();
                    sc.nextLine();
                    return;
                }
                System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                        "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                        "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                        "Seats\t\033[38;2;255;255;0m|\033[0m");
                showFlight(flight);
                String ticketId = Data.fix_length(username);
                ticketId += "@";
                ticketId += Data.fix_length(flight.getFlightId());
                Data.flights.seek(seekNow + 124);
                Data.flights.writeInt(flight.getSeats() - 1);
                Data.tickets.seek(Data.tickets.getFilePointer());
                Data.tickets.writeChars(ticketId);
                charge -= flight.getPrice();
                Data.passengers.seek(cursor + 60);
                Data.passengers.writeInt(charge);
                System.out.print("\033[38;2;255;255;200mYour ticket id is\033[38;2;255;255;0m: " + ticketId);
                sc.nextLine();
                sc.nextLine();
                return;
            }
            seekNow += 128;
        }
    }
    public void ticketCancellation(String ticketId) throws IOException {
        String flightId = ticketId.substring(16).trim();
        Data.tickets.seek(0);
        int nowSeek = 0;
        int nextSeek;
        for (int i = 0; i < Data.tickets.length()/62; i++) {
            if(ticketId.equals(Data.readFixStringTickets())){
                int k = i;
                for (int j = 0; j < Data.tickets.length()/62 - k - 1; j++) {
                    nowSeek = i*62;
                    nextSeek = nowSeek + 62;
                    if(nextSeek > Data.tickets.length())
                        break;
                    Data.tickets.seek(nextSeek);
                    String tmp = Data.readFixStringFlights();
                    Data.tickets.seek(nowSeek);
                    Data.tickets.writeChars(tmp);
                    i++;
                }
                break;
            }
        }
        Data.tickets.setLength(Data.tickets.length() - 62);
        for (int i = 0; i < Data.flights.length()/158; i++) {
            Data.flights.seek(i*158);
            if (flightId.equals(Data.readFixStringFlights())){
                Data.flights.seek(i*158 + 150);
                int seats = Data.flights.readInt();
                Data.flights.seek(i*158 + 150);
                Data.flights.writeInt(seats);
                Data.flights.seek(i*158 + 154);
                charge += Data.flights.readInt();
                break;
            }
        }
        return;
    }
    // booked ticket is based on flight id + @ + number of tickets for the flight
    public void bookedTickets(){
        int cnt = 0;

        try {
            Data.tickets.seek(0);
            for (int i = 0; i < Data.tickets.length()/62; i++) {
                String bookedTicket = Data.readFixStringTickets().substring(0, 15).trim();
                if(username.equals(bookedTicket)) {
                    System.out.println("\033[38;2;255;255;0m" + bookedTicket);
                    cnt++;
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(cnt==0)
            System.out.println("\033[38;2;255;255;200mYour booked tickets is empty!");
        sc.nextLine();
    }
    public void addCharge(){
        System.out.println("\033[38;2;0;255;0mYour charge is: " + charge + "\nEnter the charge you want to add: \033[38;2;255;255;0m");
        charge += sc.nextInt();
        System.out.println("\033[0m");
        try {
            Data.passengers.seek(cursor + 60);
            Data.passengers.writeInt(charge);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sc.nextLine();
    }
    public void showFlight(Flight flight){
        System.out.println("\033[38;2;255;255;255m.........................................................................................................\033[0m");
        System.out.printf("\033[38;2;255;255;0m|\033[38;2;255;255;200m%1$-15s" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200m%2$-15s" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200m%3$-15s" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200m%4$-15s" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200m%5$-15s" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200m%6$-,15d" +
                        "\033[38;2;255;255;0m|\033[38;2;255;255;200m%7$-7d" +
                        "\033[38;2;255;255;0m|%n\033[0m", flight.getFlightId(),
                flight.getOrigin(), flight.getDestination(), flight.getDate(),
                flight.getTime(), flight.getPrice(), flight.getSeats());
    }
    public void deleteScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
