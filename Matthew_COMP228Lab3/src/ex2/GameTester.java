// Matthew Elliott - 301424215
// October 14, 2025
// Lab #3
package ex2;

public abstract class GameTester {
    private final String name;
    private Boolean status;

    public GameTester(String name, Boolean status)
    {
        this.name = name;
        this.status = status;
    }

    // Abstract Methods
    public abstract double setSalary();

    // Return name and status:
    public String getName() { return name; }
    public Boolean getStatus() { return status; }

}
