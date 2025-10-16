// Matthew Elliott - 301424215
// October 14, 2025
// Lab #3
package ex1;

public abstract class Insurance {
    private final String description;
    private final double cost;

    // Constructor
    public Insurance(String description, double cost)
    {
        this.description = description;
        this.cost = cost;
    }

    // Return description and cost
    public String getDescription() { return description; }
    public double getCost() { return cost; }

    // Abstract methods
    public abstract double setInsuranceCost(double cost);
    public abstract String displayInfo();

}
