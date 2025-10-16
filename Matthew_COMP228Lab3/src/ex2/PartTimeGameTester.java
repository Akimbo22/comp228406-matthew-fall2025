// Matthew Elliott - 301424215
// October 14, 2025
// Lab #3
package ex2;

public class PartTimeGameTester extends GameTester {
    private double salary;
    private int hours;

    // Constructor
    public PartTimeGameTester(String name, Boolean status, int hours)
    {
        super(name, status);

        if (hours <= 0)
        {
            throw new IllegalArgumentException("Invalid entry. Number of hours must at least be 1");
        }

        this.hours = hours;
    }

    public double setSalary()
    {
        // Set salary for Part-Time Game Tester
        salary = 20 * hours;

        return salary;
    }
}
