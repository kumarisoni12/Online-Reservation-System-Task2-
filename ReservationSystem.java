
import java.util.*;

public class ReservationSystem {
    ArrayList<Ticket> tickets = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    HashMap<String, String> trainMap = new HashMap<>();

    public ReservationSystem() {
        trainMap.put("12345", "Shatabdi Express");
        trainMap.put("54321", "Rajdhani Express");
        trainMap.put("67890", "Duronto Express");
    }

    public void reserveTicket() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Available Train Numbers: " + trainMap.keySet());
        System.out.print("Enter train number: ");
        String trainNo = sc.nextLine();

        if (!trainMap.containsKey(trainNo)) {
            System.out.println("Invalid train number. Reservation cancelled.");
            return;
        }

        String trainName = trainMap.get(trainNo);
        System.out.println("Train Name (auto-filled): " + trainName);
        System.out.print("From: ");
        String from = sc.nextLine();
        System.out.print("To: ");
        String to = sc.nextLine();
        System.out.print("Date of journey: ");
        String date = sc.nextLine();
        System.out.print("Class (e.g. Sleeper/AC): ");
        String travelClass = sc.nextLine();

        Ticket temp = new Ticket(name, trainNo, trainName, from, to, date, travelClass);

        System.out.println("\nPlease confirm your reservation details:");
        temp.display();

        System.out.print("Type 'Insert' to confirm booking: ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("Insert")) {
            tickets.add(temp);
            System.out.println("Ticket booked successfully! Your PNR is: " + temp.pnr);
        } else {
            System.out.println("Reservation cancelled.");
        }
    }

    public void cancelTicket() {
        System.out.print("Enter PNR to cancel: ");
        int pnr = sc.nextInt();
        sc.nextLine(); // consume newline
        boolean found = false;
        for (Ticket t : tickets) {
            if (t.pnr == pnr) {
                System.out.println("Ticket Found:");
                t.display();
                System.out.print("Press OK to confirm cancellation: ");
                String confirm = sc.nextLine();
                if (confirm.equalsIgnoreCase("OK")) {
                    tickets.remove(t);
                    System.out.println("Ticket with PNR " + pnr + " cancelled successfully.");
                } else {
                    System.out.println("Cancellation aborted.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("PNR not found.");
        }
    }

    public void showTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Ticket t : tickets) {
                System.out.println("\n-----------------------");
                t.display();
            }
        }
    }
}
