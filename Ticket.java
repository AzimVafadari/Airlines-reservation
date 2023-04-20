public class Ticket {
    private User user;
    private Flight flight;

    public User getUser() {
        return user;
    }

    public Ticket(User user, Flight flight) {
        this.user = user;
        this.flight = flight;
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
