package WeeklyTemp;

import java.util.ArrayList;
import java.util.Scanner;

public class CT5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();
        
        for (int i = 0; i < 7; i++) {
            System.out.print("Enter the temperature for " + getDayOfWeek(i) + " : ");
            double temperatureFahrenheit = scanner.nextDouble();
            scanner.nextLine(); 
            
            days.add(getDayOfWeek(i).toLowerCase()); 
            temperatures.add(temperatureFahrenheit);
        }
        
        System.out.print("Enter 'week' for weekly average or a day of the week (Monday through Sunday): ");
        String input = scanner.nextLine().trim().toLowerCase(); 
        
        if (input.equalsIgnoreCase("week")) {
            double weeklyAverageFahrenheit = calculateWeeklyAverage(temperatures);
            System.out.println("Weekly Average Temperature: " + weeklyAverageFahrenheit + "°F");
        } else {
            int index = days.indexOf(input);
            if (index != -1) {
                System.out.println("Temperature for " + getDayOfWeek(index) + ": " + temperatures.get(index) + "°F");
            } else {
                System.out.println("Invalid input. Please enter a valid day of the week.");
            }
        }
        
        scanner.close();
    }
    
    public static double calculateWeeklyAverage(ArrayList<Double> temperatures) {
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }
        return sum / temperatures.size();
    }
    
    public static String getDayOfWeek(int index) {
        switch (index) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return "Invalid Day";
        }
    }
}