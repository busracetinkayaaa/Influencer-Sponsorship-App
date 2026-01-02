package SpringBoot.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="influencers")

public class Influencer extends BaseEntity{
    private String name;
    private String socialMediaPlatform;
    private int followers;
    private double engagementRate;
    private double totalEarnings;

    public Influencer() {
    }

    public Influencer(String name, String socialMediaPlatform, int followers, double engagementRate, double totalEarnings) {
        this.name = name;
        this.socialMediaPlatform = socialMediaPlatform;
        this.followers = followers;
        this.engagementRate = engagementRate;
        this.totalEarnings = totalEarnings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialMediaPlatform() {
        return socialMediaPlatform;
    }

    public void setSocialMediaPlatform(String socialMediaPlatform) {
        this.socialMediaPlatform = socialMediaPlatform;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public double getEngagementRate() {
        return engagementRate;
    }

    public void setEngagementRate(double engagementRate) {
        this.engagementRate = engagementRate;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

}
