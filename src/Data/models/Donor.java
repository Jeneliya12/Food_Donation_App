package Data.models;

public class Donor extends User {
    private final int donorId;

    public Donor(int donorId, String name, String email, String password) {
        super(donorId, name, email, password);
        this.donorId = donorId;
    }

    public int getDonorId() {
        return donorId;
    }
}
