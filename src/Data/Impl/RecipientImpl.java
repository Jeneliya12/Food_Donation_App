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
        System.out.println("Recipient Profile:");
        System.out.println("ID: " + recipient.getId());
        System.out.println("Name: " + recipient.getName());
        System.out.println("Email: " + recipient.getEmail());
    }

    @Override
    public void claimDonation(Donation donation) {
        if (donation == null) {
            System.out.println("Invalid donation.");
            return;
        }

        if (!donation.isClaimed()) {
            donation.setClaimedBy(recipient);
            donation.setClaimed(true);
            addClaimedDonation(donation);
            System.out.println("Donation claimed successfully!");
        } else {
            System.out.println("This donation has already been claimed.");
        }
    }

    @Override
    public void viewAvailableDonations(List<Donation> donations) {
        System.out.println("\nAvailable Donations:");

        boolean availableDonationFound = false;
        if (donations == null || donations.isEmpty()) {
            System.out.println("No donations available.");
            return;
        }

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

    @Override
    public void addClaimedDonation(Donation donation) {
        if (donation != null) {
            recipient.getClaimedDonations().add(donation); // Correctly add the donation to the recipient's list
        }
    }

    @Override
    public List<Donation> getClaimedDonations() {
        return recipient.getClaimedDonations(); // Assuming this method exists in Recipient
    }
}
