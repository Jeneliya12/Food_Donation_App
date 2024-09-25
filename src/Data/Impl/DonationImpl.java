package Data.Impl;

import Data.Interface.DonationInterface;
import Data.models.Donation;
import Data.models.Recipient;

import java.util.List;

public class DonationImpl implements DonationInterface {
    private final List<Donation> donations;

    public DonationImpl(List<Donation> donations) {
        this.donations = donations;
    }

    @Override
    public void registerDonation(Donation donation) {
        donations.add(donation);
        System.out.println("Donation registered successfully!");
    }

    @Override
    public void claimDonation(Donation donation, Recipient recipient) {
        if (!donation.isClaimed()) {
            donation.setClaimedBy(recipient);
            donation.setClaimed(true);
            recipient.getClaimedDonations().add(donation);
            System.out.println("Donation claimed successfully!");
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
            System.out.println("Donation ID: " + donation.getDonationId() + " - Food Type: " + donation.getFoodType() + " - Status: " + status);
        }
    }

    public List<Donation> getDonations() {
        return donations;
    }
}
