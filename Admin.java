import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private Scanner sc = new Scanner(System.in);
    private int command;
    private String username;
    private String password;

    private Flight flight = new Flight("YT-22", "Yazd", "Tehran", "1402/02/30", "14:55", 190000, 28);

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
    public void add() throws IOException {
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
        try {
            Data.write_flight(flight);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return;
    }
    public void update() throws IOException {
        System.out.println("\033[38;2;255;255;200mEnter the flight id\033[38;2;255;255;0m:\033[38;2;255;255;200m    ");
        String flightId = sc.next();
        int i = 0;
        String find = "";
        System.out.println(Data.flights.length());
        for (i = 0; i < Data.flights.length()/158; i++) {
            Data.flights.seek(i*158);
            find = Data.readFixStringFlights();
            if(flightId.equals(find)){
                break;
            }

        }
        Data.flights.seek(i*158);
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
                    String newFlightId = Data.fix_length(sc.next());
                    Data.flights.writeChars(newFlightId);
                    break;
                case 2:
                    System.out.print("\nOrigin\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                    String newOrigin = Data.fix_length(sc.next());
                    Data.flights.seek(i*158 + 30);
                    Data.flights.writeChars(newOrigin);
                    break;
                case 3:
                    System.out.print("\nDestination\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                    String newDestination = Data.fix_length(sc.next());
                    Data.flights.seek(i*158 + 60);
                    Data.flights.writeChars(newDestination);
                    break;
                case 4:
                    System.out.print("\nDate\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                    String newDate = Data.fix_length(sc.next());
                    Data.flights.seek(i*158 + 90);
                    Data.flights.writeChars(newDate);
                    break;
                case 5:
                    System.out.print("\nTime\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                    String newTime = Data.fix_length(sc.next());
                    Data.flights.seek(i*158 + 120);
                    Data.flights.writeChars(newTime);
                    break;
                case 6:
                    int newPrice;
                    do {
                        System.out.print("\nPrice\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                        newPrice = sc.nextInt();
                    }while(newPrice < 0);
                    Data.flights.seek(i*158 + 150);
                    Data.flights.writeInt(newPrice);
                    break;
                case 7:
                    int newSeats;
                    do {
                        System.out.print("\nSeats\033[38;2;255;255;0m:\033[38;2;255;255;200m ");
                        newSeats = sc.nextInt();
                    }while(newSeats < 0);
                    Data.flights.seek(i*158 + 154);
                    Data.flights.writeInt(newSeats);
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
    public void remove() throws IOException {
        System.out.println("\033[38;2;255;255;200mFlight id\033[38;2;255;255;0m: \033[0m");
        String flightId = sc.next();
        int i = 0;
        String find = "";
        System.out.println(Data.flights.length());
        for (i = 0; i < Data.flights.length()/158; i++) {
            Data.flights.seek(i*158);
            find = Data.readFixStringFlights();
            if(flightId.equals(find)){
                break;
            }
        }
        int k = i;
        for (int j = 0; j < Data.flights.length()/158 - k - 1; j++) {
            int nowSeek = i*158;
            //replace the flight id
            int nextSeek = nowSeek + 158;
            if(nextSeek > Data.flights.length())
                break;
            Data.flights.seek(nextSeek);
            String tmp = Data.readFixStringFlights();
            Data.flights.seek(nowSeek);
            Data.flights.writeChars(tmp);
            //replace the origin
            Data.flights.seek(nextSeek + 30);
            tmp = Data.readFixStringFlights();
            Data.flights.seek(nowSeek + 30);
            Data.flights.writeChars(tmp);
            //replace the Destination
            Data.flights.seek(nextSeek + 60);
            tmp = Data.readFixStringFlights();
            Data.flights.seek(nowSeek + 60);
            Data.flights.writeChars(tmp);
            //replace the Date
            Data.flights.seek(nextSeek + 90);
            tmp = Data.readFixStringFlights();
            Data.flights.seek(nowSeek + 90);
            Data.flights.writeChars(tmp);
            //replace the Time
            Data.flights.seek(nextSeek + 120);
            tmp = Data.readFixStringFlights();
            Data.flights.seek(nowSeek + 120);
            Data.flights.writeChars(tmp);
            //replace the Price
            Data.flights.seek(nextSeek + 150);
            int tmpInt = Data.flights.readInt();
            Data.flights.seek(nowSeek + 150);
            Data.flights.writeInt(tmpInt);
            //replace the Seats
            Data.flights.seek(nextSeek + 154);
            int Seats = Data.flights.readInt();
            Data.flights.seek(nowSeek + 154);
            Data.flights.writeInt(Seats);
            i++;
        }
        Data.flights.setLength(Data.flights.length() - 158);
        return;
    }
    public void flightSchedule() throws IOException {
        System.out.println("\033[38;2;255;255;0m|\033[38;2;255;255;200mFlightId\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                "Origin\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                "Destination\t\033[38;2;255;255;0m|\033[38;2;255;255;200mDate\t\t" +
                "\033[38;2;255;255;0m|\033[38;2;255;255;200mTime\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200mPrice\t\t\033[38;2;255;255;0m|\033[38;2;255;255;200m" +
                "Seats\t\033[38;2;255;255;0m|\033[0m");
        for (int i = 0; i < Data.flights.length()/158; i++) {
            int nowSeek = i*158;
            Data.flights.seek(nowSeek);
            System.out.println("\033[38;2;255;255;255m.........................................................................................................\033[0m");
            System.out.printf("\033[38;2;255;255;0m|\033[38;2;255;255;200m%1$-15s" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200m%2$-15s" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200m%3$-15s" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200m%4$-15s" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200m%5$-15s" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200m%6$-,15d" +
                            "\033[38;2;255;255;0m|\033[38;2;255;255;200m%7$-7d" +
                            "\033[38;2;255;255;0m|%n\033[0m", Data.readFixStringFlights(),
                    Data.readFixStringFlights(), Data.readFixStringFlights(), Data.readFixStringFlights(),
                    Data.readFixStringFlights(), Data.flights.readInt(), Data.flights.readInt());

        }
        sc.nextLine();
        return;
    }
}

