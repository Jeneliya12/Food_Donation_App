import models.Donor;
import models.Recipient;
import models.Donation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create some test donations
        List<Donation> donations = new ArrayList<>();
        donations.add(new Donation(1, "Apples", 10.0, "KG", LocalDate.of(2024, 10, 1)));
        donations.add(new Donation(2, "Bread", 5.0, "KG", LocalDate.of(2024, 9, 30)));

        // Create a donor
        Donor donor = new Donor(1, "Alice", "alice@example.com", "password123");
        donor.viewProfile();

        // Register a donation
        donor.registerDonation(3, "Oranges", 15.0, "KG", LocalDate.of(2024, 10, 5));

        // View registered donations
        donor.viewDonations();

        // Create a recipient
        Recipient recipient = new Recipient(2, "Bob", "bob@example.com", "password456");
        recipient.viewProfile();

        // View available donations
        recipient.viewAvailableDonations(donations);
    }
}
