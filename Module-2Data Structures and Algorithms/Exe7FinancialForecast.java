public class Exe7FinancialForecast {

    static double futureValue(double presentValue,
                              double growthRate,
                              int years) {

        if(years==0)
            return presentValue;

        return futureValue(
                presentValue*(1+growthRate),
                growthRate,
                years-1
        );
    }

    public static void main(String[] args) {

        double result = futureValue(
                10000,
                0.10,
                5
        );

        System.out.println("Future Value = "+result);
    }
}