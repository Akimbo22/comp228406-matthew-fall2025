// Matthew Elliott - 301424215
// October 14, 2025
// Lab #3
package ex2;

// Using the scanner to take inputs for this exercise
import java.util.Objects;
import java.util.Scanner;

public class GameTestDriver {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Game Tester application menu!");
        System.out.print("To begin, please enter your name: ");

        // Taking the user input for name
        String name = scanner.nextLine();

        System.out.println("Great! Nice to meet you, " + name + ". Next, enter if you are applying for a " +
                "full-time job or a part-time job. Please enter 'FULL' or 'PART'");
        // Continuing with either FullTimeGameTester or PartTimeGameTester, depending on user entry:
        String job = scanner.nextLine();

        if(Objects.equals(job, "FULL"))
        {
            // Setting status to true
            Boolean status = true;
            FullTimeGameTester fulltime = new FullTimeGameTester(name, status);
            System.out.printf("%s is a Full-Time employee. They make a base salary of $%.2f",
                    fulltime.getName(), fulltime.setSalary());
        }
        else if(Objects.equals(job, "PART"))
        {
            // Setting status to false
            Boolean status = false;
            System.out.println("Great. Now, enter the number of hours you will work: ");
            // Setting the hours
            int hours = Integer.parseInt(scanner.nextLine());

            PartTimeGameTester parttime = new PartTimeGameTester(name, status, hours);
            System.out.printf("%s is a Part-Time employee. They'll make $%.2f after %d hours",
                    parttime.getName(), parttime.setSalary(), hours);
        }
        else
        {
            throw new IllegalArgumentException("Invalid entry! You must enter 'FULL' or 'PART'");
        }

    }
}
