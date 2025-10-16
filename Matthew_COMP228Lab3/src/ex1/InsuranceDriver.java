// Matthew Elliott - 301424215
// October 14, 2025
// Lab #3
package ex1;

import javax.swing.*;
import java.util.Objects;

public class InsuranceDriver {
    public static void main(String[] args)
    {
        // Creating a 4-element array
        Insurance[] payments = new Insurance[4];

        // Initial loop to fill array
        int i;
        String insuranceType;
        double amount;
        for(i = 0; i < 4; i++)
        {
            insuranceType = (JOptionPane.showInputDialog(null, "Please enter 'health' or 'life': ", "Insurance Type",
                    JOptionPane.QUESTION_MESSAGE));

            // Ask for a cost
            amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the monthly cost: ", "Monthly Cost",
                    JOptionPane.QUESTION_MESSAGE));

            // Run method based on insurance type
            if (Objects.equals(insuranceType, "health"))
            {
                payments[i] = new Health(insuranceType, amount);
            }
            else if (Objects.equals(insuranceType, "life"))
            {
                payments[i] = new Life(insuranceType, amount);
            }
        }

        // Second loop to print each array entry
        for (Insurance userPayments : payments)
        {
            System.out.printf("%n%s%s %n%s: $%, .2f %s",
                    userPayments.getDescription(), " Insurance", "Payment due", userPayments.getCost(), " per month");
        }

    }
}
