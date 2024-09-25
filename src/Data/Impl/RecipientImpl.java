package Data.Impl;

import Data.Interface.RecipientInterface;
import Data.models.Donation;
import Data.models.Recipient;

import java.util.List;

public class RecipientImpl implements RecipientInterface {
    private final Recipient recipient;

    public RecipientImpl(Recipient recipient) {
        this.recipient = recipient;
    }

    @Override
    public void viewProfile() {
        recipient.viewProfile();
    }

    @Override
    public void claimDonation(Donation donation) {
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
    public void viewAvailableDonations(List<Donation> donations) {
        System.out.println("\nAvailable Donations:");

        boolean availableDonationFound = false;
        for (Donation donation : donations) {
            if (!donation.isClaimed()) {
                System.out.println(donation);
                availableDonationFound = true;
            }
        }

        if (!availableDonationFound) {
            System.out.println("No available donations.");
        }
    }
}
