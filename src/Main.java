import models.Donor;
import models.Recipient;
import models.Donation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Donor> donors = new ArrayList<>();
    private static List<Recipient> recipients = new ArrayList<>();

    static {
        donors.add(new Donor(1, "Jenny", "jenny@gmail.com", "pwd123"));

        recipients.add(new Recipient(1, "Milli", "milli@gmail.com", "pwd789"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Donation> donations = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Food Donation App ===");
            System.out.println("1. Donor Login");
            System.out.println("2. Recipient Login");
            System.out.println("3. Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Donor donor = loginDonor(scanner);
                    if (donor != null) {
                        donorMenu(donor, donations, scanner);
                    }
                    break;
                case 2:
                    Recipient recipient = loginRecipient(scanner);
                    if (recipient != null) {
                        recipientMenu(recipient, donations, scanner);
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the Food Donation App!");
                    return; // Exit the application
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static Donor loginDonor(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (Donor donor : donors) {
            // Use getEmail() instead of accessing email directly
            if (donor.getEmail().equals(email) && donor.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + donor.getName());
                return donor;
            }
        }

        System.out.println("Invalid email or password.");
        return null;
    }

    private static Recipient loginRecipient(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (Recipient recipient : recipients) {
            // Use getEmail() instead of accessing email directly
            if (recipient.getEmail().equals(email) && recipient.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + recipient.getName());
                return recipient;
            }
        }

        System.out.println("Invalid email or password.");
        return null;
    }


    private static void donorMenu(Donor donor, List<Donation> donations, Scanner scanner) {
        while (true) {
            System.out.println("\n=== Donor Menu ===");
            System.out.println("1. View Profile");
            System.out.println("2. Register Donation");
            System.out.println("3. View Donations");
            System.out.println("4. Back to Main Menu");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    donor.viewProfile();
                    break;
                case 2:
                    System.out.print("Enter Donation ID: ");
                    int donationId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Food Type: ");
                    String foodType = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    double quantity = scanner.nextDouble();
                    System.out.print("Enter Unit: ");
                    String unit = scanner.next();
                    System.out.print("Enter Expiration Date (YYYY-MM-DD): ");
                    LocalDate expirationDate = LocalDate.parse(scanner.next());

                    // Create new donation and add it to the shared list
                    Donation newDonation = new Donation(donationId, foodType, quantity, unit, expirationDate);
                    donations.add(newDonation);
                    System.out.println("Donation registered successfully");
                    break;
                case 3:
                    donor.viewDonations(donations);
                    break;
                case 4:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void recipientMenu(Recipient recipient, List<Donation> donations, Scanner scanner) {
        while (true) {
            System.out.println("\n=== Recipient Menu ===");
            System.out.println("1. View Profile");
            System.out.println("2. View Available Donations");
            System.out.println("3. Claim Donation");
            System.out.println("4. View Claimed Donations");
            System.out.println("5. Back to Main Menu");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    recipient.viewProfile();
                    break;
                case 2:
                    recipient.viewAvailableDonations(donations);
                    break;
                case 3:
                    System.out.print("Enter Donation ID to claim: ");
                    int claimId = scanner.nextInt();
                    for (Donation donation : donations) {
                        if (donation.getDonationId() == claimId) {
                            recipient.claimDonation(donation);
                            break;
                        }
                    }
                    break;
                case 4:
                    recipient.viewClaimedDonations();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
