public class Main {
    public static void main(String[] args) {
        // Hardcoded credentials
        String donorName = "Jenny";
        String donorEmail = "jen@gmail.com";
        String donorPassword = "psd123";

        String recipientName = "Milli";
        String recipientEmail = "milli@gmail.com";
        String recipientPassword = "psd456";

        // Create some test donations
        List<Donation> donations = new ArrayList<>();
        donations.add(new Donation(1, "Apples", 10.0, "KG", LocalDate.of(2024, 10, 1)));
        donations.add(new Donation(2, "Bread", 5.0, "KG", LocalDate.of(2024, 9, 30)));

        // Create a donor
        Donor donor = new Donor(1, donorName, donorEmail, donorPassword);
        donor.viewProfile();

        // Register a donation (you can add logic to this method later)
        donor.registerDonation(3, "Oranges", 15.0, "KG", LocalDate.of(2024, 10, 5));

        // View registered donations
        donor.viewDonations();

        // Create a recipient
        Recipient recipient = new Recipient(2, recipientName, recipientEmail, recipientPassword);
        recipient.viewProfile();

        // View available donations
        recipient.viewAvailableDonations(donations);
    }
}
