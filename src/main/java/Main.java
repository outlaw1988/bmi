import calculate.BMICalculator;
import picocli.CommandLine;
import picocli.CommandLine.*;

public class Main {

    @Option(names = { "-ht", "--height" }, description = "Height [m]")
    private static double height;

    @Option(names = { "-w", "--weight" }, description = "Weight [kg]")
    private static double weight;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "display this help and exit")
    private static boolean help;

    public static void main(String[] args) {
        Main app = CommandLine.populateCommand(new Main(), args);
        if (help || args.length == 0) {
            CommandLine.usage(new Main(), System.out);
            return;
        }

        try {
            BMICalculator bmi = new BMICalculator(height, weight);
            System.out.println(bmi.calculate());
            System.out.println(bmi.interpret());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
