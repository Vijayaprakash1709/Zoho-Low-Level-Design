import java.util.Scanner;

public class UserDashboard {
    private Seater seater = new Seater();
    private NonAcCoach nonAcCoach = new NonAcCoach();
    private AcCoach acCoach = new AcCoach();

    public Passenger addPassenger() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Passenger Details");
        System.out.println("Enter the Passenger Id:");
        int passengerId = sc.nextInt();
        System.out.println("Enter the Passenger Name:");
        String passengerName = sc.next();
        System.out.println("Enter the Passenger Age:");
        int age = sc.nextInt();
        System.out.println("Enter the Passenger Mail Id:");
        String mailId = sc.next();
        System.out.println("Enter the Passenger Contact Number:");
        String contactNumber = sc.next();
        System.out.println("Enter the Passenger Gender:");
        String gender = sc.next();
        return new Passenger(passengerId, passengerName, age, mailId, contactNumber, gender);
    }

    public void bookTicket() {
        Passenger passenger = addPassenger();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Coach Type (Seater, NonAcCoach, AcCoach):");
        String coachType = sc.next();
        boolean status=false;
        switch (coachType) {

            case "Seater":
                status=seater.bookTicket(passenger);
                if(status==true)
                {
                    System.out.println("Ticket Fare is Rs 50");
                }
                break;
            case "NonAcCoach":
                status=nonAcCoach.bookTicket(passenger);
                if(status==true)
                {
                    System.out.println("Ticket Fare is Rs 500");
                }
                break;
            case "AcCoach":
                status=acCoach.bookTicket(passenger);
                if(status==true)
                {
                    System.out.println("Ticket Fare is Rs 1000");
                }
                break;
            default:
                System.out.println("Invalid Coach Type");
        }

    }

    public void cancelTicket() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Passenger Id:");
        int passengerId = sc.nextInt();
        System.out.println("Enter the Coach Type (Seater, NonAcCoach, AcCoach):");
        String coachType = sc.next();

        switch (coachType) {
            case "Seater":
                seater.cancelTicket(passengerId);
                break;
            case "NonAcCoach":
                nonAcCoach.cancelTicket(passengerId);
                break;
            case "AcCoach":
                acCoach.cancelTicket(passengerId);
                break;
            default:
                System.out.println("Invalid Coach Type");
        }
    }
    public void checkAvailability() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Coach Type (Seater, NonAcCoach, AcCoach):");
        String coachType = sc.next();

        switch (coachType) {
            case "Seater":
                System.out.println("Available Seats in Seater Coach: " + (seater.getMaxConfirmedTickets()  - seater.getConfirmedTickets().size()));
                break;
            case "NonAcCoach":
                System.out.println("Available Seats in NonAcCoach Coach: " + (nonAcCoach.getMaxConfirmedTickets() - nonAcCoach.getConfirmedTickets().size()));
                break;
            case "AcCoach":
                System.out.println("Available Seats in AcCoach Coach: " + (acCoach.getMaxConfirmedTickets() - acCoach.getConfirmedTickets().size()));
                break;
            default:
                System.out.println("Invalid Coach Type");
        }
    }
    public void prepareChart() {
        System.out.println("Confirmed Tickets in Seater Coach:");
        for (Passenger passenger : seater.getConfirmedTickets()) {
            System.out.println("Passenger Id: " + passenger.getPssengerId());
        }
        System.out.println("Confirmed Tickets in NonAcCoach Coach:");
        for (Passenger passenger : nonAcCoach.getConfirmedTickets()) {
            System.out.println("Passenger Id: " + passenger.getPssengerId());
        }
        System.out.println("Confirmed Tickets in AcCoach Coach:");
        for (Passenger passenger : acCoach.getConfirmedTickets()) {
            System.out.println("Passenger Id: " + passenger.getPssengerId());
        }
    }

    public static void main(String[] args) {
        UserDashboard userDashboard = new UserDashboard();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Railway Booking System");
        boolean running = true;

        while (running) {
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Availablity Check");
            System.out.println("4. Prepare Chart");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    userDashboard.bookTicket();
                    break;
                case 2:
                    userDashboard.cancelTicket();
                    break;
                case 3:
                    userDashboard.checkAvailability();
                    break;
                case 4:
                    userDashboard.prepareChart();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
        System.out.println("Thank you for using the Railway Booking System!");
    }
}
