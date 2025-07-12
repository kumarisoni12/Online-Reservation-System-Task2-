
import java.util.*;

public class Final {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservationSystem rs = new ReservationSystem();
        List<User> users = new ArrayList<>();

        while (true) {
            System.out.println("\nWelcome to Online Reservation System");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Choose a username: ");
                String username = sc.nextLine();
                System.out.print("Choose a password: ");
                String password = sc.nextLine();
                users.add(new User(username, password));
                System.out.println("User registered successfully!");
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String u = sc.nextLine();
                System.out.print("Enter password: ");
                String p = sc.nextLine();
                boolean loggedIn = false;

                for (User usr : users) {
                    if (usr.login(u, p)) {
                        loggedIn = true;
                        break;
                    }
                }

                if (loggedIn) {
                    int subChoice;
                    do {
                        System.out.println("\n1. Reserve Ticket\n2. Cancel Ticket\n3. View Bookings\n4. Logout");
                        System.out.print("Enter your choice: ");
                        subChoice = sc.nextInt();
                        sc.nextLine(); // consume newline

                        switch (subChoice) {
                            case 1: rs.reserveTicket(); break;
                            case 2: rs.cancelTicket(); break;
                            case 3: rs.showTickets(); break;
                            case 4: System.out.println("Logged out successfully."); break;
                            default: System.out.println("Invalid choice.");
                        }
                    } while (subChoice != 4);
                } else {
                    System.out.println("Login failed. Please register first or try again.");
                }
            } else if (choice == 3) {
                System.out.println("Thank you for using the system.");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}
