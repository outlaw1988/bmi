import calculate.BMICalculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class BMICalculatorTest {

    @Test
    @Parameters({"70, 1.8, normal", "50, 1.83, very severely underweight",
            "90, 1.75, overweight", "150, 1.7, super obese", "180, 1.5, hyper obese"})
    public void testDifferentBMI(double weight, double height, String bmiStatus) {
        double bmiExpectedResult = weight / Math.pow(height, 2);
        String expected = String.format("Your BMI is: %.2f", bmiExpectedResult);
        String expectedInterpretation = String.format("You're %s", bmiStatus);

        BMICalculator bmi = new BMICalculator(height, weight);
        String bmiActualResult = bmi.calculate();
        String bmiActualInterpretation = bmi.interpret();

        assertEquals(expected, bmiActualResult);
        assertEquals(expectedInterpretation, bmiActualInterpretation);
    }

    @Test(expected = IllegalArgumentException.class)
    public void belowZero() {
        BMICalculator bmi = new BMICalculator(0, -1);
    }

}
