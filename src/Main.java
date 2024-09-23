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

        // Create a list to store donations
        List<Donation> donations = new ArrayList<>();

        // Create a donor
        Donor donor = new Donor(1, "Alice", "alice@example.com", "password123");
        donor.viewProfile();

        // Get donation details from the user
        System.out.println("Enter donation ID:");
        int donationId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter food type:");
        String foodType = scanner.nextLine();

        System.out.println("Enter quantity:");
        double quantity = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter unit:");
        String unit = scanner.nextLine();

        System.out.println("Enter expiration date (YYYY-MM-DD):");
        String dateInput = scanner.nextLine();
        LocalDate expirationDate = LocalDate.parse(dateInput);

        // Register the donation
        donor.registerDonation(donationId, foodType, quantity, unit, expirationDate);

        // Add the donation to the list
        donations.add(new Donation(donationId, foodType, quantity, unit, expirationDate));

        // Create a recipient
        Recipient recipient = new Recipient(2, "Bob", "bob@example.com", "password456");
        recipient.viewProfile();

        // View available donations
        recipient.viewAvailableDonations(donations);

        scanner.close();
    }
}
