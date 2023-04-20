public class Flight {
    private String flightId;
    private String origin;
    private String destination;
    private String date;
    private String time;
    // The number of tickets that is reserved or cancelled by this flight
    private int cntTickets = 0;

    public int getCntTickets() {
        return cntTickets;
    }

    public void setCntTickets(int cntTickets) {
        this.cntTickets = cntTickets;
    }

    public Flight(String flightId, String origin, String destination, String date, String time, int price, int seats) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seats = seats;
    }

    private int price;
    private int seats;
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
