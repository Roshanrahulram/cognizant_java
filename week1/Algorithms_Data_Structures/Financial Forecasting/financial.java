// Exercise 7: Financial Forecasting
import java.util.*;
public class financial{
    public static double futureValue(double P0, double r, int n) {
        if (n == 0) {
            return P0;
        } else {
            return futureValue(P0, r, n - 1) * (1 + r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting value:");
        double initialValue = sc.nextDouble(); 
        System.out.println("Enter the growth rate:");
        double growthRate = sc.nextDouble();   
        System.out.println("Enter number of years:");
        int years = sc.nextInt();             
        double fv = futureValue(initialValue, growthRate, years);
        System.out.println("The future value after " + years + " years is: " + fv);
        sc.close();
    }
}
