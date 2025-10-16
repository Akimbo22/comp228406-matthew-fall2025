// Matthew Elliott - 301424215
// October 14, 2025
// Lab #3
package ex1;

public class Health extends Insurance{

    // Constructor
    public Health(String description, double cost)
    {
        super(description, cost);
    }

    // Set cost per month
    @Override
    public double setInsuranceCost(double cost)
    {
        if (cost < 0.0)
            throw new IllegalArgumentException(
                    "Cost must be at least $0.0"
            );

        return cost;
    }

    public String displayInfo()
    {
        return String.format("Customer has %s insurance.%n It costs them %.2f per month!",
                getDescription(), getCost());
    }
}
