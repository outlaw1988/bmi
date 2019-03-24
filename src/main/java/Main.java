import calculate.BMICalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double height;
        double weight;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your height [m]: ");
        height = sc.nextDouble();
        System.out.println("Please enter your weight [kg]: ");
        weight = sc.nextDouble();

        try {
            BMICalculator bmi = new BMICalculator(height, weight);
            System.out.println(bmi.calculate());
            System.out.println(bmi.interpret());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
