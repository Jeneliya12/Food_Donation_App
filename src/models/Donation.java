package models;

public class Donation {
    private int donationId;
    private String foodType;
    private double quantity;
    private String unit;
    private LocalDate expirationDate;
    private boolean isClaimed;

    public Donation(int donationId, String foodType, double quantity, String unit, LocalDate expirationDate) {
        this.donationId = donationId;
        this.foodType = foodType;
        this.quantity = quantity;
        this.unit = unit;
        this.expirationDate = foodexpirationDate;
        this.isClaimed = false;
    }
}
