package models;

public class Recipient extends User {

    public Recipient (int id, String name, String email, String password) {
        super(id, name, email, password);
    }
    public void claimDonation(Donation donation) {
        if (!donation.isClaimed()) {
            donation.setClaimed(true);
            System.out.println("Donation claimed successfully!");
        } else {
            System.out.println("The donation has already been claimed.");
        }

    }
    public void viewAvailableDonations(List<Donation> donations){
        System.out.println("Available Donations:");
        for (Donation donation : donations) {
            if (!donation.isClaimed()) {
                System.out.println(donation);
            }
        }
    }
    public void viewProfile() {
        System.out.println("Recipient Name: " + this.name);
    }
}
