import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Data {

    private static final int FIX_SIZE = 15;
    public static RandomAccessFile flights;

    static {
        try {
            flights = new RandomAccessFile("data/flights.dat", "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static RandomAccessFile passengers;

    static {
        try {
            passengers = new RandomAccessFile("data/passengers.dat", "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static RandomAccessFile admins;

    static {
        try {
            admins = new RandomAccessFile("data/admins.dat", "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static RandomAccessFile tickets;

    static {
        try {
            tickets = new RandomAccessFile("data/tickets.dat", "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //this method fix the length of a string
    public static String fix_length(String string){
        String fixed_string = "";
        if(string.length() == FIX_SIZE){
            fixed_string = string;
        }else if(string.length() > FIX_SIZE){
            fixed_string = string.substring(0, FIX_SIZE);
        }else {
            while(string.length() < FIX_SIZE){
                string += " ";
            }
            fixed_string = string;
        }
        return fixed_string;
    }

    //this method write a flight in the flights file
    public static void write_flight(Flight flight) throws IOException {
        try {
            flights.writeChars(fix_length(flight.getFlightId()));
            flights.writeChars(fix_length(flight.getOrigin()));
            flights.writeChars(fix_length(flight.getDestination()));
            flights.writeChars(fix_length(flight.getDate()));
            flights.writeChars(fix_length(flight.getTime()));
            flights.writeInt(flight.getPrice());
            flights.writeInt(flight.getSeats());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //this method read fix string from flights file


    public static String readFixStringFlights() throws IOException {
        String tmp = "";
        for (int i = 0; i < FIX_SIZE; i++) {
            tmp += flights.readChar();
        }
        return tmp.trim();
    }

    //this method read fix string from Admins file
    public static String readFixStringAdmins() throws IOException {
        String tmp = "";
        for (int i = 0; i < FIX_SIZE; i++) {
            tmp += admins.readChar();
        }
        return tmp.trim();
    }
    //this method read fix string from passenger file
    public static String readFixStringPassengers() throws IOException {
        String tmp = "";
        for (int i = 0; i < FIX_SIZE; i++) {
            tmp += passengers.readChar();
        }
        return tmp.trim();
    }
}
