package calculate;

import java.util.Arrays;

public class BMICalculator implements Calculator {

    private double weight;
    private double height;
    private double bmi;

    public BMICalculator(double height, double weight) {

        if (height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Height/weight cannot equals or less than zero");
        }

        this.height = height;
        this.weight = weight;
    }

    @Override
    public String calculate() {
        bmi = weight / Math.pow(height, 2);
        return String.format("Your BMI is: %.2f", bmi);
    }

    @Override
    public String interpret() {
        double[] bmiNumers = {15, 16, 18.5, 25, 30, 35, 40, 45, 50, 60};
        String[] bmiResults = {"very severely underweight", "severely underweight", "underweight",
                "normal", "overweight", "moderately obese", "severely obese",
                "very severely obese", "morbidly obese", "super obese", "hyper obese"};

        int index = Arrays.binarySearch(bmiNumers, bmi);

        if (index < 0) {
            index = Math.abs(index) - 1;
        }

        String bmiResult = bmiResults[index];

        return String.format("You're %s", bmiResult);
    }
}
