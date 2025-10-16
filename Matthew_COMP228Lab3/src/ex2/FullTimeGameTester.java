// Matthew Elliott - 301424215
// October 14, 2025
// Lab #3
package ex2;

public class FullTimeGameTester extends GameTester {
    private double salary;

    // Constructor
    public FullTimeGameTester(String name, Boolean status)
    {
        super(name, status);
    }

    public double setSalary()
    {
        // Set salary for Full-Time Game Tester
        salary+=3000;

        return salary;
    }


}
