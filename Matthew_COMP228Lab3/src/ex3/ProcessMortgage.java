// Matthew Elliott - 301424215
// October 14, 2025
// Lab #3
package ex3;

import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Creating the array
        MortgageConstants[] mortgages = new MortgageConstants[3];

        int i;
        for(i=0; i< mortgages.length; i++) {
            System.out.println("Hello! Welcome to CityToronto bank.");
            System.out.println("To begin, enter your interest rate (2%=0.02, for example): ");
            double interestRate = scanner.nextDouble();

            System.out.println("Next, your mortgage ID number: ");
            String mortgageNum = scanner.next();

            System.out.println("Next, your mortgage amount: ");
            double amount = scanner.nextDouble();

            System.out.println("Next, your name: ");
            String name = scanner.next();

            System.out.println("Now, is this a 1 year mortgage, 3 year mortgage, or 5 year mortgage: ");
            int term = scanner.nextInt();
            if (term == 1 || term == 3 || term == 5) {
                System.out.println("Finally, enter 1 for a Business Mortgage. Enter 2 for a Personal Mortgage");
                int mortgageType = scanner.nextInt();

                if(mortgageType == 1)
                {
                    mortgages[i] = new BusinessMortgage(mortgageNum, name, amount, term, interestRate);
                }
                else if(mortgageType == 2)
                {
                    mortgages[i] = new PersonalMortgage(mortgageNum, name, amount, term, interestRate);
                }
            }
            else {
                throw new IllegalArgumentException("Illegal entry. Mortgage term must be 1 year, 3 years, or 5 years");
            }


        }

        // Second loop to take data out of array:
        for (MortgageConstants userMortgages : mortgages)
        {
            System.out.println(userMortgages.getMortgageInfo());
        }



    }

}
