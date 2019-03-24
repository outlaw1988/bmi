package calculate;

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
        String bmiResult = "";

        if (bmi <= 15) {
            bmiResult = "very severely underweight";
        } else if (bmi > 15 && bmi <= 16) {
            bmiResult = "severely underweight";
        } else if (bmi > 16 && bmi <= 18.5) {
            bmiResult = "underweight";
        } else if (bmi > 18.5 && bmi <= 25 ) {
            bmiResult = "normal";
        } else if (bmi > 25 && bmi <= 30) {
            bmiResult = "overweight";
        } else if (bmi > 30 && bmi <= 35) {
            bmiResult = "obese class I";
        } else if (bmi > 35) {
            bmiResult = "obese high class";
        }

        return String.format("You're %s", bmiResult);
    }
}
