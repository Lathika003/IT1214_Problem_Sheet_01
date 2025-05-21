class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() { return ticketNumber; }
    public String getCustomerName() { return customerName; }
    public int getSeatNumber() { return seatNumber; }
}

class BookingSystem {
    private Ticket[] tickets = new Ticket[10]; 
    private int bookedCount = 0;

    public void bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (bookedCount >= tickets.length) {
            System.out.println("Booking failed: Theater is full.");
            return;
        }
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number.");
            return;
        }
        for (int i = 0; i < bookedCount; i++) {
            if (tickets[i].getSeatNumber() == seatNumber) {
                System.out.println("Seat " + seatNumber + " is already booked.");
                return;
            }
        }
        tickets[bookedCount++] = new Ticket(ticketNumber, customerName, seatNumber);
    }

    public void cancelTicket(int ticketNumber) {
        int index = -1;
        for (int i = 0; i < bookedCount; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Ticket number " + ticketNumber + " not found.");
            return;
        }
        
        for (int i = index; i < bookedCount - 1; i++) {
            tickets[i] = tickets[i + 1];
        }
        tickets[--bookedCount] = null;
    }

    public void displayTickets() {
        System.out.println("Ticket Number  Customer Name  Seat Number");
        for (int i = 0; i < bookedCount; i++) {
System.out.println(tickets[i].getTicketNumber() + "\t" + tickets[i].getCustomerName() + "\t" + tickets[i].getSeatNumber());        }
    }
}

 class MovieBooking {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

    
        bookingSystem.bookTicket(1, "Alice", 1);
        bookingSystem.bookTicket(2, "Bob", 2);
        bookingSystem.bookTicket(3, "Carol", 3);

        
        bookingSystem.cancelTicket(2);

        
        bookingSystem.bookTicket(4, "Dave", 2);

        
        bookingSystem.displayTickets();
    }
}