package Data.models;

import java.util.ArrayList;
import java.util.List;

public class Recipient extends User {
    private final List<Donation> claimedDonations;

    public Recipient(int id, String name, String email, String password) {
        super(id, name, email, password);
        this.claimedDonations = new ArrayList<>();
    }

    public List<Donation> getClaimedDonations() {
        return claimedDonations;
    }
}
