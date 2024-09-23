package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Donor extends User { // Ensure it's public
    private final List<Donation> donations;

    public Donor(int id, String name, String email, String password) {
        super(id, name, email, password);
        this.donations = new ArrayList<>();
    }

    public void registerDonation(int donationId, String foodType, double quantity, String unit, LocalDate expirationDate) {
        Donation newDonation = new Donation(donationId, foodType, quantity, unit, expirationDate);
        donations.add(newDonation);
        System.out.println("Donation registered successfully");
    }

    public void viewDonations() {
        System.out.println("Your Donations:");
        for (Donation donation : donations) {
            System.out.println("Donation ID: " + donation.getDonationId() + ", Food Type: " + donation.getFoodType());
        }
    }

    public void viewDonationStatus() {
        for (Donation donation : donations) {
            String status = donation.isClaimed() ? "Claimed" : "Available";
            System.out.println("Donation ID: " + donation.getDonationId() + " - Status: " + status);
        }
    }

    @Override
    public void viewProfile() {
        System.out.println("Donor Name: " + this.name);
    }
}
