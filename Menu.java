import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
   public Menu() {
        menuOptions();
    }
    public int command;
    private User user = new User(0);
    private Admin admin = new Admin();
    public Scanner sc = new Scanner(System.in);

    public void menuOptions(){
        deleteScreen1();
        System.out.println("\033[38;2;255;255;200m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n\033[38;2;255;255;200m                       WELCOME TO AIRLINE RESERVATION SYSTEM                         " +
                "\n\033[38;2;255;255;200m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "\033[38;2;255;255;200m.....................................MENU OPTION.........................................\n\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m1\033[38;2;255;255;200m> Sign in\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m2\033[38;2;255;255;200m> Sign up\n\033[0m");
        command = sc.nextInt();
        deleteScreen1();
        switch (command){
            case 1:
                deleteScreen1();
                System.out.println("\033[38;2;255;255;200m<\033[38;2;255;255;0m1\033[38;2;255;255;200m> Admin\n" +
                        "\033[38;2;255;255;200m<\033[38;2;255;255;0m2\033[38;2;255;255;200m> Passenger\n\033[0m");
                command = sc.nextInt();
                System.out.println("\033[38;2;255;255;200musername\033[38;2;255;255;0m: ");
                String username = sc.next();
                System.out.println("\033[0m");
                System.out.println("\033[38;2;255;255;200mpassword\033[38;2;255;255;0m: ");
                String password = sc.next();
                System.out.println("\033[0m");
                switch (command) {
                    case 1:
                        if(username.equals("Admin") && password.equals("Admin")){
                            adminMenuOptions();
                        }
                        try {
                            int seekNow = 0;
                            Data.admins.seek(seekNow);
                            for (int i = 0; i < Data.admins.length()/60; i++) {
                                if (username.equals(Data.readFixStringAdmins())){
                                    if(password.equals(Data.readFixStringAdmins())){
                                        admin.setUsername(username);
                                        admin.setPassword(password);
                                        adminMenuOptions();
                                    }else{
                                        break;
                                    }
                                }
                                seekNow += 30;
                                Data.admins.seek(seekNow);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        try {
                            int seekNow = 0;
                            Data.passengers.seek(seekNow);
                            for (int i = 0; i < Data.passengers.length()/64; i++) {
                                if (username.equals(Data.readFixStringPassengers())){
                                    if(password.equals(Data.readFixStringPassengers())){
                                        user.setUsername(username);
                                        user.setPassword(password);
                                        user.setCharge(Data.passengers.readInt());
                                        user = new User((int) (Data.passengers.getFilePointer() - 64));
                                        passengerMenuOptions();
                                    }else{
                                        break;
                                    }
                                }
                                seekNow += 34;
                                Data.passengers.seek(seekNow);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                }
                break;
            case 2:
                deleteScreen1();
                System.out.println("\033[38;2;255;255;200m<\033[38;2;255;255;0m1\033[38;2;255;255;200m> Admin\n" +
                        "\033[38;2;255;255;200m<\033[38;2;255;255;0m2\033[38;2;255;255;200m> Passenger\n\033[0m");
                command = sc.nextInt();
                System.out.println("\033[38;2;255;255;200musername\033[38;2;255;255;0m: ");
                username = Data.fix_length(sc.next());
                System.out.println("\033[0m");
                System.out.println("\033[38;2;255;255;200mpassword\033[38;2;255;255;0m: ");
                password = Data.fix_length(sc.next());
                System.out.println("\033[0m");
                switch (command) {
                    case 1:
                        boolean isExist = false;
                        try {
                            int seekNow = 0;
                            Data.admins.seek(seekNow);
                            for (int i = 0; i < Data.admins.length()/60; i++) {
                                if (username.trim().equals(Data.readFixStringAdmins())){
                                    System.out.println("\033[38;2;255;255;200mThis admin is already existing\033[38;2;255;255;0m!");
                                    sc.nextLine();
                                    isExist = true;
                                    break;
                                }
                                seekNow += 30;
                                Data.admins.seek(seekNow);
                            }
                            if (isExist)
                                break;
                            Data.admins.seek(Data.admins.length());
                            Data.admins.writeChars(username);
                            Data.admins.writeChars(password);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        isExist = false;
                        try {
                            int seekNow = 0;
                            Data.passengers.seek(seekNow);
                            for (int i = 0; i < Data.passengers.length()/64; i++) {
                                if (username.trim().equals(Data.readFixStringPassengers())){
                                    System.out.println("\033[38;2;255;255;200mThis passenger is already existing\033[38;2;255;255;0m!");
                                    sc.nextLine();
                                    isExist = true;
                                    break;
                                }
                                seekNow += 34;
                                Data.passengers.seek(seekNow);

                            }
                            if (isExist)
                                break;
                            Data.passengers.seek(Data.passengers.length());
                            Data.passengers.writeChars(username);
                            Data.passengers.writeChars(password);
                            Data.passengers.writeInt(0);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                }
                break;
            default:
                System.out.println("Enter correct command :)");
                break;
        }
        sc.nextLine();
        menuOptions();
    }
    public void adminMenuOptions() {
        deleteScreen1();
        System.out.println("\033[38;2;255;255;200m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n\033[38;2;255;255;200m                                  ADMIN MENU OPTIONS                                       " +
                "\n\033[38;2;255;255;200m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "\033[38;2;255;255;200m.........................................................................................\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m1\033[38;2;10;255;100m\033[38;2;255;255;200m> Add\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m2\033[38;2;10;255;100m\033[38;2;255;255;200m> Update\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m3\033[38;2;10;255;100m\033[38;2;255;255;200m> Remove\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m4\033[38;2;10;255;100m\033[38;2;255;255;200m> Flight schedule\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m0\033[38;2;10;255;100m\033[38;2;255;255;200m> Sign out\033[0m");
        command = sc.nextInt();
        deleteScreen1();
        switch (command){
            case 0:
                return;
            case 1:
                try {
                    admin.add();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                try {
                    admin.update();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                try {
                    admin.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 4:
                try {
                    admin.flightSchedule();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                break;
        }
        adminMenuOptions();
    }
    public void passengerMenuOptions() throws IOException {
        deleteScreen1();
        System.out.println("\033[38;2;255;255;200m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n                                \033[38;2;255;255;200mPASSENGER MENU OPTIONS                                         " +
                "\n\033[38;2;255;255;200m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                ".........................................................................................\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m1\033[38;2;255;255;200m> Change password\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m2\033[38;2;255;255;200m> Search flights tickets\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m3\033[38;2;255;255;200m> Booking ticket\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m4\033[38;2;255;255;200m>\033[38;2;255;0;0m Ticket cancellation\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m5\033[38;2;255;255;200m> Booked tickets\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m6\033[38;2;255;255;200m>\033[38;2;0;255;0m Add charge\n" +
                "\033[38;2;255;255;200m<\033[38;2;255;255;0m0\033[38;2;255;255;200m> Sign out\033[0m");
        command = sc.nextInt();
        deleteScreen1();
        switch (command){
            case 0:
                return;
            case 1:
                user.changePassword();
                break;
            case 2:
                user.searchFlightsTickets();
                break;
            case 3:
                user.bookingTicket();
                break;
            case 4:
                System.out.println("\033[38;2;130;255;130mEnter your ticket id: \033[0m");
                String ticketId = sc.next();
                user.ticketCancellation(ticketId);
                break;
            case 5:
                user.bookedTickets();
                break;
            case 6:
                user.addCharge();
                break;
            default:
                break;
        }
        sc.nextLine();
        passengerMenuOptions();
    }
    public void deleteScreen1(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}