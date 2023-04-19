import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    public static Scanner sc = new Scanner(System.in);
    public static int command;
    public int cnt_flight = 3;
    private String username = "Admin";
    private String password = "Admin";
    private ArrayList<Flight> flights = new ArrayList<Flight>();
    private Flight flight;
    public Admin(String username, String password, ArrayList<Flight> flights) {
        this.username = username;
        this.password = password;
        this.flights = flights;
        flight = new Flight("WX-12 ", "Yazd", "Tehran", "1401-12-10", "12:30", 700000, 51);
        this.flights.add(flight);
        flight = new Flight("WX-15 ", "Mashhad", "Ahvaz", "1401-12-11", "08:00", 900000, 245);
        this.flights.add(flight);
        flight = new Flight("BG-22", "Shiraz", "Tabriz", "1401-12-12", "22:30", 1100000, 12);
        this.flights.add(flight);
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
        System.out.print("\033[38;2;255;255;200mFlight id\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
        flight.setFlightId(sc.next());
        System.out.print("Origin\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
        flight.setOrigin(sc.next());
        System.out.print("Destination\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
        flight.setDestination(sc.next());
        System.out.print("Date\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
        flight.setDate(sc.next());
        System.out.print("Time\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
        flight.setTime(sc.next());
        do {
            System.out.print("Price\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
            flight.setPrice(sc.nextInt());
        }while (flight.getPrice() < 0);
        do {
            System.out.print("Seats\033[38;2;255;255;0m: ");
            flight.setSeats(sc.nextInt());
        }while(flight.getSeats() < 0);
        System.out.println("\033[38;2;255;255;200m\033[0m");
        flights.add(flight);
        return;
    }
    public void update() {
        System.out.println("\033[38;2;255;255;200mEnter the flight id\033[38;2;255;255;0m:\033[38;2;255;255;200m    ");
        String id = sc.next();
        int i;
        for (i = 0; i < cnt_flight; i++) {
            if(id == flights.get(i).getFlightId())
                break;
        }
        i--;
        System.out.println("\033[38;2;255;255;200m<\033[38;2;255;255;0m1\033[38;2;255;255;200m> Flight id\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m2\033[38;2;255;255;200m> Origin\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m3\033[38;2;255;255;200m> Destination\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m4\033[38;2;255;255;200m> Date\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m5\033[38;2;255;255;200m> Time\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m6\033[38;2;255;255;200m> Price\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m7\033[38;2;255;255;200m> Seats\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m-1\033[38;2;255;255;200m> Return\n");
        int command = sc.nextInt();
        deleteScreen();
        while(command != -1){
            switch(command){
                case 1:
                    System.out.print("\033[38;2;255;255;200mFlight id\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                    flights.get(i).setFlightId(sc.next());
                    break;
                case 2:
                    System.out.print("\nOrigin\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                    flights.get(i).setOrigin(sc.next());
                    break;
                case 3:
                    System.out.print("\nDestination\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                    flights.get(i).setDestination(sc.next());
                    break;
                case 4:
                    System.out.print("\nDate\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                    flights.get(i).setDate(sc.next());
                    break;
                case 5:
                    System.out.print("\nTime\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                    flights.get(i).setTime(sc.next());
                    break;
                case 6:
                    do {
                        System.out.print("\nPrice\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                        flights.get(i).setPrice(sc.nextInt());
                    }while(flight.getPrice() < 0);
                    break;
                case 7:
                    do {
                        System.out.print("\nSeats\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                        flights.get(i).setSeats(sc.nextInt());
                    }while(flight.getSeats() < 0);
                    break;
            }
            deleteScreen();
            System.out.println("\033[38;2;255;255;200m<\033[38;2;255;255;0m1\033[38;2;255;255;200m> Flight id\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m2\033[38;2;255;255;200m> Origin\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m3\033[38;2;255;255;200m> Destination\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m4\033[38;2;255;255;200m> Date\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m5\033[38;2;255;255;200m> Time\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m6\033[38;2;255;255;200m> Price\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m7\033[38;2;255;255;200m> Seats\n" +
                    "\033[38;2;255;255;200m<\033[38;2;255;255;0m-1\033[38;2;255;255;200m> Return\n\033[0m");
            command = sc.nextInt();
            deleteScreen();
        }
        return;
    }
    public void deleteScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void remove(){
        System.out.println("\033[38;2;255;255;200mFlight id\033[38;2;255;255;0m: \033[0m");
        String target = sc.next();
        for (int i = 0; i < cnt_flight; i++) {
            if(flights.get(i).getFlightId() == target)
                flights.remove(i);
        }
        cnt_flight--;
        return;
    }
    public void flightSchedule(){
        System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                "Seats\t\033[38;2;255;255;0m|\033[0m");
        for (int i = 0; i < cnt_flight; i++) {
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
        sc.nextLine();
        return;
    }
}
