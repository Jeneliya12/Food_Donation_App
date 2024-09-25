package Data.Interface;

import Data.models.Donation;

import java.util.List;

public interface DonorInterface {
    void viewProfile();
    void viewDonations(List<Donation> donations);
}
