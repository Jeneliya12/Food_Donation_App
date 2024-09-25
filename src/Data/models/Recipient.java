package Data.models;

import Data.Interface.UserInterface;
import java.util.ArrayList;
import java.util.List;

public class Recipient extends User implements UserInterface {
    private List<Donation> claimedDonations; // List to store claimed donations

    public Recipient(int id, String name, String email, String password) {
        super(id, name, email, password);
        this.claimedDonations = new ArrayList<>(); // Initialize the list
    }

    // Method to add a claimed donation
    public void addClaimedDonation(Donation donation) {
        claimedDonations.add(donation);
    }

    // Method to retrieve claimed donations
    public List<Donation> getClaimedDonations() {
        return claimedDonations;
    }
}
