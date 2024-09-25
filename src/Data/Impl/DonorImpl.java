package Data.Impl;

import Data.Interface.DonorInterface;
import Data.models.Donation;
import Data.models.Donor;

import java.util.List;

public class DonorImpl implements DonorInterface {
    private final Donor donor;

    public DonorImpl(Donor donor) {
        this.donor = donor;
    }

    @Override
    public void viewProfile() {
        System.out.println("Donor Profile:");
        System.out.println("ID: " + donor.getId());
        System.out.println("Name: " + donor.getName());
        System.out.println("Email: " + donor.getEmail());
    }

    @Override
    public void viewDonations(List<Donation> donations) {
        System.out.println("Donations by " + donor.getName() + ":");
        if (donations.isEmpty()) {
            System.out.println("No donations found.");
            return;
        }
        for (Donation donation : donations) {
            System.out.println("Food Type: " + donation.getFoodType());
            System.out.println("Quantity: " + donation.getQuantity() + donation.getUnit());
            System.out.println("Expiration Date: " + donation.getExpirationDate());
            System.out.println("Status: " + (donation.isClaimed() ? "Claimed" : "Available"));
            System.out.println();
        }
    }

    public Donor getDonor() {
        return donor;
    }
}
