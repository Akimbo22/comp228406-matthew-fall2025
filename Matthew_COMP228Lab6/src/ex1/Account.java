package ex1;

import java.security.SecureRandom;

public class Account implements Runnable {

    private final float deposit;
    private final float withdraw;
    private float bankTotal;
    public static final SecureRandom waitForBank = new SecureRandom();
    public final int bankSleep;

    public Account(float deposit, float withdraw, float bankTotal)
    {
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.bankTotal = bankTotal;
        bankSleep = waitForBank.nextInt(5000);
    }

    public void run()
    {
        try
        {
            System.out.printf("Welcome! Your starting amount is: $%f \n",
                    bankTotal);

            System.out.printf("Bank will deposit $%f to account total: $%f \n",
                    deposit, bankTotal);
            bankTotal += deposit;
            System.out.printf("New total after deposit is: $%f \n",
                    bankTotal);

            if (withdraw <= bankTotal)
            {
                System.out.printf("Bank will withdraw $%f from account total: $%f \n",
                        withdraw, bankTotal);
                bankTotal -= withdraw;
                System.out.printf("New total after withdrawal is: $%f \n", bankTotal);
            }
            Thread.sleep(bankSleep);
        } catch (InterruptedException exception)
        {
            exception.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
}
