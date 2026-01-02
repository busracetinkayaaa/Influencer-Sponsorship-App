package SpringBoot.demo.dto;

public class OfferRequest {
    private Long influencer_id;
    private Long brand_id;
    private double moneyAmount;

    public OfferRequest() {
    }

    public OfferRequest(Long influencer_id, Long brand_id, double moneyAmount) {
        this.influencer_id = influencer_id;
        this.brand_id = brand_id;
        this.moneyAmount = moneyAmount;
    }

    public Long getInfluencer_id() {
        return influencer_id;
    }

    public void setInfluencer_id(Long influencer_id) {
        this.influencer_id = influencer_id;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
