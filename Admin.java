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
        System.out.print("Flight id: ");
        flight.setFlightId(sc.next());
        System.out.print("Origin: ");
        flight.setOrigin(sc.next());
        System.out.print("Destination: ");
        flight.setDestination(sc.next());
        System.out.print("Date: ");
        flight.setDate(sc.next());
        System.out.print("Time: ");
        flight.setTime(sc.next());
        System.out.print("Price: ");
        flight.setPrice(sc.nextInt());
        System.out.print("Seats: ");
        flight.setSeats(sc.nextInt());
        flights.add(flight);
    }
    public void update() {
        System.out.println("Enter the flight id:    ");
        String id = sc.next();
        int i;
        for (i = 0; i < cnt_flight; i++) {
            if(id == flights.get(i).getFlightId())
                break;
        }
        i--;
        System.out.println("1.Flight id\n2.Origin\n3.Destination\n4.Date\n5.Time\n6.Price\n7.Seats\n-1.Return");
        int command = sc.nextInt();
        while(command != -1){
            switch(command){
                case 1:
                    System.out.print("\nFlight id: ");
                    flights.get(i).setFlightId(sc.next());
                    break;
                case 2:
                    System.out.print("\nOrigin: ");
                    flights.get(i).setOrigin(sc.next());
                    break;
                case 3:
                    System.out.print("\nDestination: ");
                    flights.get(i).setDestination(sc.next());
                    break;
                case 4:
                    System.out.print("\nDate: ");
                    flights.get(i).setDate(sc.next());
                    break;
                case 5:
                    System.out.print("\nTime: ");
                    flights.get(i).setTime(sc.next());
                    break;
                case 6:
                    System.out.print("\nPrice: ");
                    flights.get(i).setPrice(sc.nextInt());
                    break;
                case 7:
                    System.out.print("\nSeats: ");
                    flights.get(i).setSeats(sc.nextInt());
                    break;
            }
            deleteScreen();
            System.out.println("<1> Flight id\n<2> Origin\n<3> Destination\n<4> Date\n<5> Time\n<6> Price\n<7> Seats\n<-1> Return\n");
            command = sc.nextInt();
        }
        return;
    }
    public static void deleteScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void remove(){
        System.out.println("Flight id:  ");
        String target = sc.next();
        for (int i = 0; i < cnt_flight; i++) {
            if(flights.get(i).getFlightId() == target)
                flights.remove(i);
        }
        cnt_flight--;
        return;
    }
    public void flightSchedule(){
        System.out.println("|FlightId\t\t\t|Origin\t\t\t\t|Destination\t\t\t|Date\t\t\t\t|Time\t\t\t|Price\t\t\t|Seats|");
        for (int i = 0; i < cnt_flight; i++) {
            System.out.println("................................................................................................");
            System.out.printf("|%s\t\t\t\t|%s\t\t\t\t|%s\t\t\t\t\t|%s\t\t\t\t|%s\t\t\t\t|%d\t\t\t\t|%d|%n", flights.get(i).getFlightId(), flights.get(i).getOrigin(), flights.get(i).getDestination(), flights.get(i).getDate(), flights.get(i).getTime(), flights.get(i).getPrice(), flights.get(i).getSeats());
        }
    }
}
