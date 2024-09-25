package Data.models;

import java.time.LocalDate;

public class Donation {
    private final int id;
    private final int donorId;
    private final String foodType;
    private final double quantity;
    private final String unit;
    private final LocalDate expirationDate;
    private boolean isClaimed;
    private Recipient claimedBy;

    public Donation(int id, int donorId, String foodType, double quantity, String unit, LocalDate expirationDate) {
        this.id = id;
        this.donorId = donorId;
        this.foodType = foodType;
        this.quantity = quantity;
        this.unit = unit;
        this.expirationDate = expirationDate;
        this.isClaimed = false;
    }

    public int getDonationId() {
        return id;
    }

    public int getDonorId() {
        return donorId;
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
        return "Donation ID: " + id +
                ", Donor ID: " + donorId +
                ", Food Type: " + foodType +
                ", Quantity: " + quantity + " " + unit +
                ", Expiration Date: " + expirationDate +
                ", Claimed: " + isClaimed;
    }
}
