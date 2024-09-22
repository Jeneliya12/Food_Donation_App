package models;

public class Recipient extends User {
    public Recipient (int id, String name, String email, String password) {
        super(id, name, email, password);
    }
    public void claimDonation() {

    }
    public void viewAvailableDonations(){

    }
    public void viewProfile() {
        System.out.println("Recipient Name: " + this.name);
    }
}
