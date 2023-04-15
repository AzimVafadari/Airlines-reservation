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
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n                       WELCOME TO AIRLINE RESERVATION SYSTEM                         " +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                ".....................................MENU OPTION.........................................\n\n" +
                "<1> Sign in\n<2> Sign up\n");
        command = sc.nextInt();
        deleteScreen1();
        switch (command){
            case 1:
                System.out.println("username: ");
                String username = sc.next();
                System.out.println("password: ");
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
                System.out.println("username: ");
                this.user.setUsername(sc.next());
                System.out.println("password: ");
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
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n                                  ADMIN MENU OPTIONS                                       " +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                ".........................................................................................\n" +
                "<1> Add\n<2> Update\n<3> Remove\n<4> Flight schedule\n<0> Sign out");
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
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n                                PASSENGER MENU OPTIONS                                         " +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                ".........................................................................................\n" +
                "<1> Change password\n<2> Search flights tickets\n<3> Booking ticket\n" +
                "<4> Ticket cancellation\n<5> Booked tickets\n<6> Add charge\n<0> Sign out");
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
        passengerMenuOptions();
    }

    public static void deleteScreen1(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}