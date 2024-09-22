package models;

class Donor extends User {
    public Donor(int id, String name, String email, String password) {
        super(id, name, email, password);
    }
    public void registerDonation() {

    }
    public void viewDonations() {

    }

    public void viewDonationStatus() {

    }

    public void viewProfile() {
        System.out.println("Donor Name: " + this.name);
    }
}
