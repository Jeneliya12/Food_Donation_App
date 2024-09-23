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
            donation.setClaimedBy(this); // Set the claimed by recipient
            donation.setClaimed(true); // Set claimed status
            claimedDonations.add(donation); // Add to claimed list
            System.out.println("Donation claimed successfully!");
        } else {
            System.out.println("The donation has already been claimed.");
        }
    }

    public void viewClaimedDonations() {
        System.out.println("\n=== Claimed Donations ===");
        if (claimedDonations.isEmpty()) {
            System.out.println("No claimed donations.");
            return;
        }
        for (Donation donation : claimedDonations) {
            System.out.println(donation);
        }
    }

    public void viewAvailableDonations(List<Donation> donations) {
        System.out.println("\n=== Available Donations ===");

        boolean availableDonationFound = false;

        for (Donation donation : donations) {
            if (!donation.isClaimed()) {
                System.out.println("ID: " + donation.getDonationId());
                System.out.println("Food Type: " + donation.getFoodType());
                System.out.println("Quantity: " + donation.getQuantity() + " " + donation.getUnit());
                System.out.println("Expiration Date: " + donation.getExpirationDate());
                System.out.println("-------------------");
                availableDonationFound = true;
            }
        }

        if (!availableDonationFound) {
            System.out.println("No available donations at the moment. All donations have been claimed.");
        }
    }

    @Override
    public void viewProfile() {
        System.out.println("Recipient Name: " + this.name);
    }
}
