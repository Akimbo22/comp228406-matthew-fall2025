// Matthew Elliott - 301424215
// October 14, 2025
// Lab #3
package ex3;

public abstract class Mortgage implements MortgageConstants {
    private String mortgageNum;
    private String name;
    private double amount;
    private double interestRate;

    // Constructor
    public Mortgage(String mortgageNum, String name, double amount)
    {
        if(amount > 300000)
        {
            throw new IllegalArgumentException("Invalid Entry. Mortgage amount cannot be above $300,000");
        }

        this.mortgageNum = mortgageNum;
        this.name = name;
        this.amount = amount;
    }

    // Returning all values except interest rate
    public String getMortgageNum() {return mortgageNum;}
    public String getName() {return name;}
    public double getAmount() {return amount;}
}
