package Data.Interface;

import Data.models.Donation;
import Data.models.Recipient;

public interface DonationInterface {
    void registerDonation(Donation donation);
    void claimDonation(Donation donation, Recipient recipient);
    void viewDonationStatus();
}
