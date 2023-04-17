import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<User> users = new ArrayList<User>();
    private int cnt_flight = 0;
    private int cnt_user = 0;
    private int userNumber = 0;
    public static int command;
    private ArrayList<Flight> flights = new ArrayList<Flight>();
    private User user = new User(flights);
    private Admin admin = new Admin("Admin", "Admin", flights);
    public static Scanner sc = new Scanner(System.in);
    public void menuOptions(){
        deleteScreen1();
        System.out.println("\033[38;2;255;255;215m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n\033[38;2;255;255;255m                       WELCOME TO AIRLINE RESERVATION SYSTEM                         " +
                "\n\033[38;2;255;255;215m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "\033[38;2;255;255;215m.....................................MENU OPTION.........................................\n\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m1\033[38;2;255;255;215m> Sign in\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m2\033[38;2;255;255;215m> Sign up\n\033[0m");
        command = sc.nextInt();
        deleteScreen1();
        switch (command){
            case 1:
                System.out.println("\033[38;2;255;255;215musername: \033[0m");
                String username = sc.next();
                System.out.println("\033[38;2;255;255;215mpassword: \033[0m");
                String password = sc.next();
                if(username.equals("Admin")&&password.equals("Admin"))
                    adminMenuOptions();
                else{
                    for (int i = 0; i < cnt_user; i++) {
                        if(username.equals(users.get(i).getUsername()) && password.equals(users.get(i).getPassword())){
                            userNumber = i;
                            passengerMenuOptions();
                        }
                    }
                }
                break;
            case 2:
                System.out.println("\033[38;2;255;255;215musername: \033[0m");
                this.user.setUsername(sc.next());
                System.out.println("\033[38;2;255;255;215mpassword: \033[0m");
                this.user.setPassword(sc.next());
                users.add(user);
                cnt_user++;
                break;
            default:
                System.out.println("Enter correct command :)");
                break;
        }
        sc.nextLine();
        menuOptions();
    }
    public void adminMenuOptions(){
        deleteScreen1();
        System.out.println("\033[38;2;255;255;215m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n\033[38;2;255;255;255m                                  ADMIN MENU OPTIONS                                       " +
                "\n\033[38;2;255;255;215m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "\033[38;2;255;255;215m.........................................................................................\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m1\033[38;2;10;255;100m\033[38;2;255;255;215m> Add\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m2\033[38;2;10;255;100m\033[38;2;255;255;215m> Update\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m3\033[38;2;10;255;100m\033[38;2;255;255;215m> Remove\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m4\033[38;2;10;255;100m\033[38;2;255;255;215m> Flight schedule\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m0\033[38;2;10;255;100m\033[38;2;255;255;215m> Sign out\033[0m");
        command = sc.nextInt();
        deleteScreen1();
        switch (command){
            case 0:
                return;
            case 1:
                this.admin.add();
                break;
            case 2:
                this.admin.update();
                break;
            case 3:
                this.admin.remove();
                break;
            case 4:
                admin.flightSchedule();
                break;
            default:
                break;
        }
        adminMenuOptions();
    }
    public void passengerMenuOptions(){
        deleteScreen1();
        System.out.println("\033[38;2;255;255;215m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n                                \033[38;2;255;255;255mPASSENGER MENU OPTIONS                                         " +
                "\n\033[38;2;255;255;215m:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                ".........................................................................................\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m1\033[38;2;255;255;215m> Change password\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m2\033[38;2;255;255;215m> Search flights tickets\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m3\033[38;2;255;255;215m> Booking ticket\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m4\033[38;2;255;255;215m>\033[38;2;255;0;0m Ticket cancellation\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m5\033[38;2;255;255;215m> Booked tickets\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m6\033[38;2;255;255;215m>\033[38;2;0;255;0m Add charge\n" +
                "\033[38;2;255;255;215m<\033[38;2;255;255;0m0\033[38;2;255;255;215m> Sign out\033[0m");
        command = sc.nextInt();
        deleteScreen1();
        switch (command){
            case 0:
                return;
            case 1:
                users.get(userNumber).changePassword();
                break;
            case 2:
                users.get(userNumber).searchFlightsTickets();
                break;
            case 3:
                users.get(userNumber).bookingTicket();
                break;
            case 4:
                users.get(userNumber).ticketCancellation();
                break;
            case 5:
                users.get(userNumber).bookedTickets();
                break;
            case 6:
                users.get(userNumber).addCharge();
                break;
            default:
                break;
        }
        sc.nextLine();
        passengerMenuOptions();
    }

    public static void deleteScreen1(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}