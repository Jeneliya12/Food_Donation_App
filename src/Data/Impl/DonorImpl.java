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
        donor.viewProfile();
    }

    @Override
    public void viewDonations(List<Donation> donations) {
        System.out.println("Donations by " + donor.getName() + ":");
        if (donations.isEmpty()) {
            System.out.println("No donations found.");
            return;
        }
        for (Donation donation : donations) {
            System.out.println(donation);
        }
    }
}
