package SpringBoot.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="brands")

public class Brand extends BaseEntity {
    private String name;
    private double budget;

    public Brand() {}

    public Brand(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
