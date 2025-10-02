//Matthew Elliott - 301424215
//October 1, 2025
// Lab #2
package ex3;

public class Overloaded {
    // For my example of Method Overloading, I'm going to use an addition method.

    // Method #1, adding two integers:
    public int add(int a, int b)
    {
        return a+b;
    }
    // Method #2, adding four integers:
    public int add(int a, int b, int c, int d)
    {
        return a+b+c+d;
    }
    // Method #3, adding 4 doubles
    public double add(double a, double b, double c, double d)
    {
        return a+b+c+d;
    }
}
