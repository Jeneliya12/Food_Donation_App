package Data.Client;

import Data.Impl.DonationImpl;
import Data.Impl.DonorImpl;
import Data.Impl.RecipientImpl;
import Data.models.Donation;
import Data.models.Donor;
import Data.models.Recipient;
import Data.Interface.UserInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
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
        scanner.nextLine();
        UserInterface currentUser = authenticateUser(scanner, "donor");
        if (currentUser != null) {
            donorMenu(scanner, donationService, (Donor) currentUser);
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private static void recipientLogin(Scanner scanner) {
        scanner.nextLine();
        UserInterface currentUser = authenticateUser(scanner, "recipient");
        if (currentUser != null) {
            RecipientImpl recipientImpl = new RecipientImpl((Recipient) currentUser); // Create RecipientImpl instance
            recipientMenu(scanner, donationService, recipientImpl);
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private static UserInterface authenticateUser(Scanner scanner, String userType) {
        System.out.println("===== User Authentication =====");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if ("donor".equals(userType)) {
            for (Donor donor : donors) {
                if (donor.getEmail().equals(email) && donor.getPassword().equals(password)) {
                    return donor;
                }
            }
        } else if ("recipient".equals(userType)) {
            for (Recipient recipient : recipients) {
                if (recipient.getEmail().equals(email) && recipient.getPassword().equals(password)) {
                    return recipient;
                }
            }
        }
        return null;
    }

    private static void donorMenu(Scanner scanner, DonationImpl donationService, Donor currentUser) {
        DonorImpl donorImpl = new DonorImpl(currentUser);
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
                    viewMyDonations(donationService, donorImpl);
                    break;
                case 3:
                    donorImpl.viewProfile();
                    break;
                case 4:
                    System.out.println("Thank you for using the Donation App! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void recipientMenu(Scanner scanner, DonationImpl donationService, RecipientImpl recipientImpl) {
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
                    recipientImpl.viewAvailableDonations(donationService.getDonations());
                    break;
                case 2:
                    claimDonation(scanner, donationService, recipientImpl);
                    break;
                case 3:
                    recipientImpl.viewProfile();
                    break;
                case 4:
                    System.out.println("Thank you for using the Donation App! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerDonation(Scanner scanner, DonationImpl donationService, Donor currentUser) {
        scanner.nextLine();
        System.out.println("\n===== Register Donation =====");
        System.out.print("Enter food type: ");
        String foodType = scanner.nextLine();
        System.out.print("Enter quantity: ");
        double quantity = scanner.nextDouble();
        System.out.print("Enter unit (e.g., kg): ");
        String unit = scanner.next();
        System.out.print("Enter Food expiration date (yyyy-mm-dd): ");
        String expirationDateStr = scanner.next();
        LocalDate expirationDate = LocalDate.parse(expirationDateStr);

        int donationId = donations.size() + 1;

        Donation donation = new Donation(donationId, currentUser.getId(), foodType, quantity, unit, expirationDate);

        donationService.registerDonation(donation);
        System.out.println("Donation registered successfully.");
    }

    private static void viewMyDonations(DonationImpl donationService, DonorImpl donorImpl) {
        List<Donation> myDonations = donationService.getDonationsByDonorId(donorImpl.getDonor().getId());
        donorImpl.viewDonations(myDonations);
    }

    private static void claimDonation(Scanner scanner, DonationImpl donationService, RecipientImpl recipientImpl) {
        donationService.viewDonationStatus();
        System.out.print("Enter the food type of the donation you want to claim: ");
        String foodType = scanner.next();

        for (Donation donation : donationService.getDonations()) {
            if (donation.getFoodType().equals(foodType) && !donation.isClaimed()) {
                recipientImpl.claimDonation(donation);
                return;
            }
        }
        System.out.println("Donation not found or already claimed.");
    }
}