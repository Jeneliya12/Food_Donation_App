package Data.models;

import Data.Interface.UserInterface;

public class Donor extends User implements UserInterface{
    private final int donorId;

    public Donor(int donorId, String name, String email, String password) {
        super(donorId, name, email, password);
        this.donorId = donorId;
    }
    public int getDonorId() {
        return donorId;
    }
}
