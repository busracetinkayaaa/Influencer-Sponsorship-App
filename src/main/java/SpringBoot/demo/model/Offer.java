package SpringBoot.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name="influencer_id")
    private Influencer influencer;

    private double moneyAmount;
    private boolean accepted;

    public Offer() {
    }

    public Offer(Brand brand, Influencer influencer, double moneyAmount, boolean accepted) {
        this.brand = brand;
        this.influencer = influencer;
        this.moneyAmount = moneyAmount;
        this.accepted = accepted;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }
}
