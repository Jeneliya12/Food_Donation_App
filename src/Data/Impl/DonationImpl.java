package Data.Impl;

import Data.Interface.DonationInterface;
import Data.models.Donation;
import Data.models.Recipient;

import java.util.List;
import java.util.stream.Collectors;

public class DonationImpl implements DonationInterface {
    private final List<Donation> donations;

    public DonationImpl(List<Donation> donations) {
        this.donations = donations;
    }

    @Override
    public void registerDonation(Donation donation) {
        donations.add(donation);
    }

    @Override
    public void claimDonation(Donation donation, Recipient recipient) {
        if (!donation.isClaimed()) {
            donation.setClaimedBy(recipient);
            donation.setClaimed(true);
            recipient.getClaimedDonations().add(donation);
        } else {
            System.out.println("This donation has already been claimed.");
        }
    }

    @Override
    public void viewDonationStatus() {
        System.out.println("=== Donation Status ===");
        if (donations.isEmpty()) {
            System.out.println("No donations available.");
            return;
        }

        for (Donation donation : donations) {
            String status = donation.isClaimed() ? "Claimed" : "Available";
            System.out.println("Food Type: " + donation.getFoodType());
            System.out.println("Quantity: " + donation.getQuantity() + donation.getUnit());
            System.out.println("Expiration Date: " + donation.getExpirationDate());
            System.out.println("Status: " + status);
            System.out.println();
        }
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public List<Donation> getDonationsByDonorId(int donorId) {
        return donations.stream()
                .filter(donation -> donation.getDonorId() == donorId)
                .collect(Collectors.toList());
    }
}
