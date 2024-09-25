package Data.Interface;

import Data.models.Donation;

import java.util.List;

public interface RecipientInterface {
    void viewProfile();
    void claimDonation(Donation donation);
    void viewAvailableDonations(List<Donation> donations);
    void addClaimedDonation(Donation donation);
    List<Donation>getClaimedDonations();
}
