package main;

import models.Donor;
import models.Recipient;
import models.Donation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Donation> donations = new ArrayList<>();
        Donor donor = new Donor(1, "Alice", "alice@example.com", "password123");
        Recipient recipient = new Recipient(2, "Bob", "bob@example.com", "password456");

        while (true) {
            System.out.println("\n=== Food Donation App ===");
            System.out.println("1. Donor Options");
            System.out.println("2. Recipient Options");
            System.out.println("3. Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    donorMenu(donor, donations, scanner);
                    break;
                case 2:
                    recipientMenu(recipient, donations, scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using the Food Donation App!");
                    return; // Exit the application
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
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
                    donor.registerDonation(donationId, foodType, quantity, unit, expirationDate);
                    break;
                case 3:
                    donor.viewDonations();
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
            System.out.println("4. Back to Main Menu");
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
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
