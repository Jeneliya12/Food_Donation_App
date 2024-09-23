package models;

import java.time.LocalDate;

public class Donation {
    private final int donationId;
    private final String foodType;
    private final double quantity;
    private final String unit;
    private final LocalDate expirationDate;
    private boolean isClaimed;
    private Recipient claimedBy; // Add claimedBy field

    public Donation(int donationId, String foodType, double quantity, String unit, LocalDate expirationDate) {
        this.donationId = donationId;
        this.foodType = foodType;
        this.quantity = quantity;
        this.unit = unit;
        this.expirationDate = expirationDate;
        this.isClaimed = false;
        this.claimedBy = null; // Initially no recipient
    }

    public int getDonationId() {
        return donationId;
    }

    public String getFoodType() {
        return foodType;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public boolean isClaimed() {
        return isClaimed;
    }

    public void setClaimed(boolean claimed) {
        this.isClaimed = claimed;
    }

    public Recipient getClaimedBy() {
        return claimedBy;
    }

    public void setClaimedBy(Recipient claimedBy) {
        this.claimedBy = claimedBy;
    }

    @Override
    public String toString() {
        return "Donation ID: " + donationId +
                ", Food Type: " + foodType +
                ", Quantity: " + quantity + " " + unit +
                ", Expiration Date: " + expirationDate +
                ", Claimed: " + isClaimed;
    }
}
