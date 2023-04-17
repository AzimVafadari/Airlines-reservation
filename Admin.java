import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    public static Scanner sc = new Scanner(System.in);
    public static int command;
    public int cnt_flight = 0;
    private String username = "Admin";
    private String password = "Admin";
    private ArrayList<Flight> flights = new ArrayList<Flight>();
    private Flight flight;
    public Admin(String username, String password, ArrayList<Flight> flights) {
        this.username = username;
        this.password = password;
        this.flights = flights;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
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
    public void add(){
        cnt_flight++;
        flight = new Flight();
        System.out.print("\033[38;2;255;255;215mFlight id\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
        flight.setFlightId(sc.next());
        System.out.print("Origin\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
        flight.setOrigin(sc.next());
        System.out.print("Destination\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
        flight.setDestination(sc.next());
        System.out.print("Date\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
        flight.setDate(sc.next());
        System.out.print("Time\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
        flight.setTime(sc.next());
        System.out.print("Price\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
        flight.setPrice(sc.nextInt());
        System.out.print("Seats\033[38;2;255;255;0m: \033[0m");
        flight.setSeats(sc.nextInt());
        flights.add(flight);
        return;
    }
    public void update() {
        System.out.println("\033[38;2;255;255;215mEnter the flight id\033[38;2;255;255;0m:\033[38;2;255;255;215m    ");
        String id = sc.next();
        int i;
        for (i = 0; i < cnt_flight; i++) {
            if(id == flights.get(i).getFlightId())
                break;
        }
        i--;
        System.out.println("\033[38;2;255;255;215m<\033[38;2;255;255;0m1\033[38;2;255;255;215m> Flight id\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m2\033[38;2;255;255;215m> Origin\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m3\033[38;2;255;255;215m> Destination\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m4\033[38;2;255;255;215m> Date\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m5\033[38;2;255;255;215m> Time\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m6\033[38;2;255;255;215m> Price\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m7\033[38;2;255;255;215m> Seats\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m-1\033[38;2;255;255;215m> Return\n\033[0m");
        int command = sc.nextInt();
        while(command != -1){
            switch(command){
                case 1:
                    System.out.print("\n\033[38;2;255;255;215mFlight id\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
                    flights.get(i).setFlightId(sc.next());
                    break;
                case 2:
                    System.out.print("\nOrigin\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
                    flights.get(i).setOrigin(sc.next());
                    break;
                case 3:
                    System.out.print("\nDestination\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
                    flights.get(i).setDestination(sc.next());
                    break;
                case 4:
                    System.out.print("\nDate\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
                    flights.get(i).setDate(sc.next());
                    break;
                case 5:
                    System.out.print("\nTime\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
                    flights.get(i).setTime(sc.next());
                    break;
                case 6:
                    System.out.print("\nPrice\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
                    flights.get(i).setPrice(sc.nextInt());
                    break;
                case 7:
                    System.out.print("\nSeats\033[38;2;255;255;0m:\033[38;2;255;255;215m ");
                    flights.get(i).setSeats(sc.nextInt());
                    break;
            }
            deleteScreen();
            System.out.println("\033[38;2;255;255;215m<\033[38;2;255;255;0m1\033[38;2;255;255;215m> Flight id\n" +
                    "\033[38;2;255;255;215m<\033[38;2;255;255;0m2\033[38;2;255;255;215m> Origin\n" +
                    "\033[38;2;255;255;215m<\033[38;2;255;255;0m3\033[38;2;255;255;215m> Destination\n" +
                    "\033[38;2;255;255;215m<\033[38;2;255;255;0m4\033[38;2;255;255;215m> Date\n" +
                    "\033[38;2;255;255;215m<\033[38;2;255;255;0m5\033[38;2;255;255;215m> Time\n" +
                    "\033[38;2;255;255;215m<\033[38;2;255;255;0m6\033[38;2;255;255;215m> Price\n" +
                    "\033[38;2;255;255;215m<\033[38;2;255;255;0m7\033[38;2;255;255;215m> Seats\n" +
                    "\033[38;2;255;255;215m<\033[38;2;255;255;0m-1\033[38;2;255;255;215m> Return\n\033[0m");
            command = sc.nextInt();
        }
        return;
    }
    public static void deleteScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void remove(){
        System.out.println("\033[38;2;255;255;215mFlight id\033[38;2;255;255;0m: \033[0m");
        String target = sc.next();
        for (int i = 0; i < cnt_flight; i++) {
            if(flights.get(i).getFlightId() == target)
                flights.remove(i);
        }
        cnt_flight--;
        return;
    }
    public void flightSchedule(){
        System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;215mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;215m" +
                "Origin\t\033[38;2;255;255;0m|\033[38;2;255;255;215m" +
                "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;215mDate\t" +
                "\033[38;2;255;255;0m|\033[38;2;255;255;215mTime\t\033[38;2;255;255;0m|\033[38;2;255;255;215mPrice\t\033[38;2;255;255;0m|\033[38;2;255;255;215m" +
                "Seats\033[38;2;255;255;0m|\033[0m");
        for (int i = 0; i < cnt_flight; i++) {
            System.out.println("\033[38;2;255;255;255m.......................................................................\033[0m");
            System.out.printf("\033[38;2;255;255;0m|\033[38;2;255;255;215m%s\t\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;215m%s\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;215m%s\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;215m%s\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;215m%s\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;215m%d\t" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;215m%d" +
                            "\033[38;2;255;255;0m|%n\033[0m", flights.get(i).getFlightId(),
                    flights.get(i).getOrigin(), flights.get(i).getDestination(), flights.get(i).getDate(),
                    flights.get(i).getTime(), flights.get(i).getPrice(), flights.get(i).getSeats());
        }
        sc.nextLine();
        return;
    }
}
