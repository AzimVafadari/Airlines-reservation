import java.util.ArrayList;

public class Ticket {
    private User user;
    private Flight flight;
    private String ticketId;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(User user, Flight flight, String ticketId) {
        this.user = user;
        this.flight = flight;
        this.ticketId = ticketId;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
