import Data.Impl.DonationImpl;
import Data.models.Donation;
import Data.models.Donor;
import Data.models.Recipient;
import Data.Interface.UserInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Donor> donors = new ArrayList<>();
    private static final List<Recipient> recipients = new ArrayList<>();
    private static final List<Donation> donations = new ArrayList<>();
    private static final DonationImpl donationService = new DonationImpl(donations);

    static {
        donors.add(new Donor(1, "Jenny", "jenny@gmail.com", "pwd123"));
        donors.add(new Donor(2, "Milesca", "milesca@gmail.com", "pwd123"));
        recipients.add(new Recipient(1, "Milli", "milli@gmail.com", "pwd789"));
        recipients.add(new Recipient(2, "John", "john@gmail.com", "pwd789"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Main menu loop
        while (running) {
            System.out.println("\n===== Welcome to the Donation App =====");
            System.out.println("1. Donor Login");
            System.out.println("2. Recipient Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int userTypeChoice = scanner.nextInt();

            switch (userTypeChoice) {
                case 1:
                    donorLogin(scanner);
                    break;
                case 2:
                    recipientLogin(scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using the Donation App! Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void donorLogin(Scanner scanner) {
        scanner.nextLine(); // Consume the newline left-over
        UserInterface currentUser = authenticateUser(scanner, "donor");
        if (currentUser != null) {
            donorMenu(scanner, donationService, (Donor) currentUser);
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private static void recipientLogin(Scanner scanner) {
        scanner.nextLine(); // Consume the newline left-over
        UserInterface currentUser = authenticateUser(scanner, "recipient");
        if (currentUser != null) {
            recipientMenu(scanner, donationService, (Recipient) currentUser);
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private static UserInterface authenticateUser(Scanner scanner, String userType) {
        System.out.println("===== User Authentication =====");
        System.out.print("Enter email: ");
        String email = scanner.nextLine(); // Read email input
        System.out.print("Enter password: ");
        String password = scanner.nextLine(); // Read password input

        if (userType.equals("donor")) {
            for (Donor donor : donors) {
                if (donor.getEmail().equals(email) && donor.getPassword().equals(password)) {
                    return donor;
                }
            }
        } else if (userType.equals("recipient")) {
            for (Recipient recipient : recipients) {
                if (recipient.getEmail().equals(email) && recipient.getPassword().equals(password)) {
                    return recipient;
                }
            }
        }

        return null; // User not found
    }

    private static void donorMenu(Scanner scanner, DonationImpl donationService, Donor currentUser) {
        while (true) {
            System.out.println("\n===== Donor Menu =====");
            System.out.println("1. Register a Donation");
            System.out.println("2. View My Donations");
            System.out.println("3. View My Profile");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerDonation(scanner, donationService, currentUser);
                    break;
                case 2:
                    viewMyDonations(donationService, currentUser);
                    break;
                case 3:
                    viewDonorProfile(currentUser);
                    break;
                case 4:
                    System.out.println("Thank you for using the Donation App! Goodbye!");
                    return; // Exit
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void recipientMenu(Scanner scanner, DonationImpl donationService, Recipient currentRecipient) {
        while (true) {
            System.out.println("\n===== Recipient Menu =====");
            System.out.println("1. View Available Donations");
            System.out.println("2. Claim a Donation");
            System.out.println("3. View Profile");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    donationService.viewDonationStatus();
                    break;
                case 2:
                    claimDonation(scanner, donationService, currentRecipient);
                    break;
                case 3:
                    viewRecipientProfile(currentRecipient);
                    break;
                case 4:
                    System.out.println("Thank you for using the Donation App! Goodbye!");
                    return; // Exit
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerDonation(Scanner scanner, DonationImpl donationService, Donor currentUser) {
        scanner.nextLine(); // Consume newline left-over
        System.out.println("\n===== Register Donation =====");
        System.out.print("Enter food type: ");
        String foodType = scanner.nextLine();
        System.out.print("Enter quantity: ");
        double quantity = scanner.nextDouble();
        System.out.print("Enter unit (e.g., kg): ");
        String unit = scanner.next();
        System.out.print("Enter expiration date (YYYY-MM-DD): ");
        LocalDate expirationDate = LocalDate.parse(scanner.next());

        // Create a new donation associated with the current user
        Donation donation = new Donation(donationService.getDonations().size() + 1, foodType, quantity, unit, expirationDate, currentUser.getId());
        donationService.registerDonation(donation);
        System.out.println("Donation registered successfully!");
    }

    private static void claimDonation(Scanner scanner, DonationImpl donationService, Recipient currentRecipient) {
        donationService.viewDonationStatus();
        System.out.print("Enter Donation ID to claim: ");
        int donationId = scanner.nextInt();
        Donation donation = donationService.getDonations().stream()
                .filter(d -> d.getDonationId() == donationId)
                .findFirst()
                .orElse(null);

        if (donation != null && !donation.isClaimed()) {
            donationService.claimDonation(donation, currentRecipient);
            System.out.println("Donation claimed successfully!");
        } else {
            System.out.println("Invalid donation ID or donation already claimed.");
        }
    }

    private static void viewDonorProfile(UserInterface currentUser) {
        if (currentUser instanceof Donor donor) {
            System.out.println("\n===== Donor Profile =====");
            System.out.println("Name: " + donor.getName());
            System.out.println("Email: " + donor.getEmail());
        } else {
            System.out.println("No profile information available.");
        }
    }

    private static void viewRecipientProfile(Recipient recipient) {
        System.out.println("\n===== Recipient Profile =====");
        System.out.println("Name: " + recipient.getName());
        System.out.println("Email: " + recipient.getEmail());
    }

    private static void viewMyDonations(DonationImpl donationService, Donor currentUser) {
        System.out.println("\n===== My Donations =====");
        List<Donation> myDonations = donationService.getDonations().stream()
                .filter(donation -> donation.getDonorId() == currentUser.getId()) // Filter by current donor's ID
                .toList();

        if (myDonations.isEmpty()) {
            System.out.println("No donations available.");
        } else {
            myDonations.forEach(System.out::println);
        }
    }
}
