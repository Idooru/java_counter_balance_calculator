package calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatingPart cp = new CalculatingPart();
        PathPart pp = new PathPart();

        pp.createLogDirectory();

        while (true) {
            int[] moneys = cp.moneyInput();
            int sumResult = cp.moneyAccumulator(moneys);
            String[] stringResults = cp.showMeTheMoney(sumResult);
            pp.createLogFile(stringResults, moneys);
        }
    }
}

