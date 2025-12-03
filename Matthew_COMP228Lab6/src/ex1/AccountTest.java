package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();

        Account transaction1 = new Account(50, 25, 0);
        Account transaction2 = new Account(75, 100, 25);
        Account transaction3 = new Account(50, 25, 0);

        //list.add(transaction1);


        System.out.println("Starting Bank!");


        ExecutorService executorService = Executors.newCachedThreadPool();

        // Unfinished attempt to create list to run each transaction
//        for (int i = 0; i < list.size(); i++)
//        {
//            executorService.execute(i);
//        }

        // Starting the Account tasks:
        executorService.execute(transaction1);
        executorService.execute(transaction2);
        executorService.execute(transaction3);

        executorService.shutdown();



    }
}
