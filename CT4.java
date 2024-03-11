package CT4;

import java.util.Scanner;

public class CT4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] grades = new double[10];

        for (int i = 0; i < 10; i++) {
            while (true) {
                try {
                    System.out.print("Enter grade " + (i + 1) + ": ");
                    grades[i] = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }

        double sum = 0;
        double maximum = grades[0];
        double minimum = grades[0];
        for (double grade : grades) {
            sum += grade;
            if (grade > maximum) {
                maximum = grade;
            }
            if (grade < minimum) {
                minimum = grade;
            }
        }
        double average = sum / grades.length;

        System.out.println("Statistics:");
        System.out.println("Average grade: " + average);
        System.out.println("Maximum grade: " + maximum);
        System.out.println("Minimum grade: " + minimum);

        scanner.close();
    }
}
