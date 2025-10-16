// Matthew Elliott - 301424215
// October 14, 2025
// Lab #3
package ex3;

public class BusinessMortgage extends Mortgage {
    private double interestRate;
    private int term;

    public BusinessMortgage(String mortgageNum, String name, double amount, int term, double interestRate)
    {
        super(mortgageNum, name, amount);
        // Set interest rate to 1%
        this.interestRate = interestRate+0.01;

        this.term = term;

        // Running maxMortgage to see if amount exceeds $300,000
        maxMortgage();
    }

    @Override
    public int getTerm() { return term; }

    @Override
    public String getBank()
    {
        String bank = "CityToronto";
        return bank;
    }

    // Check if number exceeds maximum
    @Override
    public void maxMortgage()
    {
        if(getAmount() > 300000)
        {
            throw new IllegalArgumentException("Invalid entry! Mortgage amount cannot be above $300,000");
        }

    }

    @Override
    public String getMortgageInfo(){
        return String.format("Business Mortgage owner: %s%n%s: %s%s%s%n %s%.2f",
                super.toString(), "Bank and Term:", getBank(), getTerm(), " years.", "With an interest rate of: ", interestRate);
    }

}
