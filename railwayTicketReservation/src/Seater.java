import java.util.ArrayList;
import java.util.List;

public class Seater {
    private List<Passenger> confirmedTickets = new ArrayList<>();
    private List<Passenger> waitingListTickets = new ArrayList<>();
    private static final int MAX_CONFIRMED_TICKETS = 60;
    private static final int MAX_WAITING_LIST = 10;

    public Seater() {}
    public int getMaxConfirmedTickets() {
        return MAX_CONFIRMED_TICKETS;
    }
    public List<Passenger> getConfirmedTickets() {
        return confirmedTickets;
    }

    public boolean bookTicket(Passenger passenger) {
        if (confirmedTickets.size() < MAX_CONFIRMED_TICKETS) {
            confirmedTickets.add(passenger);
            System.out.println("Ticket Booked Successfully for Passenger id " + passenger.getPssengerId());
            return true;
        } else if (waitingListTickets.size() < MAX_WAITING_LIST) {
            waitingListTickets.add(passenger);
            System.out.println("Ticket is in Waiting List for Passenger id " + passenger.getPssengerId());
            return true;
        } else {
            System.out.println("Sorry, The Tickets are Full");

        }
        return false;
    }

    public void cancelTicket(int passengerId) {
        for (Passenger passenger : confirmedTickets) {
            if (passenger.getPssengerId() == passengerId) {
                confirmedTickets.remove(passenger);
                System.out.println("Ticket Cancelled Successfully for Passenger id " + passengerId);
                return;
            }
        }
        for (Passenger passenger : waitingListTickets) {
            if (passenger.getPssengerId() == passengerId) {
                waitingListTickets.remove(passenger);
                System.out.println("Ticket Cancelled Successfully for Passenger id " + passengerId);
                return;
            }
        }
        System.out.println("Passenger ID not found.");
    }
}
