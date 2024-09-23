package models;

import java.util.ArrayList;
import java.util.List;

public class Recipient extends User {
    private final List<Donation> claimedDonations; // Declare as final

    public Recipient(int id, String name, String email, String password) {
        super(id, name, email, password);
        this.claimedDonations = new ArrayList<>(); // Initialize the list
    }

    public void claimDonation(Donation donation) {
        if (!donation.isClaimed()) {
            donation.setClaimed(true);
            claimedDonations.add(donation); // Modify contents
            System.out.println("Donation claimed successfully!");
        } else {
            System.out.println("The donation has already been claimed.");
        }
    }

    public void viewClaimedDonations() {
        System.out.println("Claimed Donations:");
        if (claimedDonations.isEmpty()) {
            System.out.println("No claimed donations.");
            return;
        }
        for (Donation donation : claimedDonations) {
            System.out.println(donation);
        }
    }

    public void viewAvailableDonations(List<Donation> donations) {
        System.out.println("Available Donations:");
        if (donations.isEmpty()) {
            System.out.println("No donations available.");
            return;
        }
        for (Donation donation : donations) {
            if (!donation.isClaimed()) {
                System.out.println(donation);
            }
        }
    }

    @Override
    public void viewProfile() {
        System.out.println("Recipient Name: " + this.name);
    }
}
