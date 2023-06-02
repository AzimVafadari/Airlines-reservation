import java.io.IOException;

/**
 * Author: Azim Vafadari
 * Date: 1402/01/05
 * Computer engineering student of Yazd State University located in Yazd province in Iran
 */
public class Main{
    public static void main(String[] args) {
        try {
            Data.flights.seek(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Menu menu = new Menu();
    }
}