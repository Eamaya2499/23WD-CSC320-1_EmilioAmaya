package ct3;
/**
 *  This is a program to calculate the average withholding for customers within the income guidelines,
 *  in this program, we will include a tax rate for incomes less than 500, less than 1500, less than
 *  2500, as well as a tax for incomes greater or equal to 2500
 */
import java.util.Scanner;

public class ct3 {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner Tax = new Scanner(System.in);
        // Next we will ask the user to enter their weekly income
        System.out.print("Enter weekly income: $");
        double income = Tax.nextDouble();
        // Close the Scanner to release the gathered info
        Tax.close();

        // Now we must determine the appropriate tax rate based on the income range
        double taxRate;
        // If income is less than $500, use a tax rate of 10%
        if (income < 500) {
            taxRate = 0.10;
            // If income is greater than/equal to $500 and less than $1500, use a tax rate of 15%
        } else if (income < 1500) {
            taxRate = 0.15;
            // If income is greater than/equal to $1500 and less than $2500, use a tax rate of 20%
        } else if (income < 2500) {
            taxRate = 0.20;
            // If income is greater than/equal to $2500, use a tax rate of 30%
        } else {
            taxRate = 0.30;
        }
       
        // Calculate the tax withholding amount
        double taxWithholding = income * taxRate;
        // Print the outcome
        System.out.printf("Weekly average tax withholding: $%.2f%n", taxWithholding);
    }
}