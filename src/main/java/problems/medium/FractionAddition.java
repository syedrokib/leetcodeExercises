package problems.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/fraction-addition-and-subtraction/
class FractionAddition {
    static String fractionAddition(String expression) {

        //TODO: expression does not start with -
        if (!expression.startsWith("-")) expression = "+" + expression;

        List<String> fractions = new ArrayList<>();

        for (String token : expression.split("[-+]")) {

            if ("".equals(token)) continue;

            final String positiveToken = "+" + token;
            final String negativeToken = "-" + token;

            if (expression.contains(positiveToken)) {
                expression = expression.replace(positiveToken, "");
                fractions.add(positiveToken.replace("+", ""));
            } else {
                expression = expression.replace(negativeToken, "");
                fractions.add(negativeToken);
            }
        }

        int commonDenominator = 1;

        for (String fraction : fractions) {
            final String denominator = fraction.split("[/]")[1];
            commonDenominator *= Integer.parseInt(denominator);
        }

        List<String> newFractions = new ArrayList<>();

        for (String fraction : fractions) {
            String numerator = fraction.split("[/]")[0];
            String denominator = fraction.split("[/]")[1];

            int ratio = commonDenominator / Integer.valueOf(denominator);

            if (numerator.startsWith("-")) {
                newFractions.add("-" + Integer.parseInt(numerator.replace("-", "")) * ratio + "/" + commonDenominator);
            } else {
                newFractions.add(Integer.parseInt(numerator) * ratio + "/" + commonDenominator);
            }
        }


        int sum = 0;
        for (String fraction : newFractions) {

            String numerator = fraction.split("[/]")[0];

            if (numerator.startsWith("-")) sum -= Integer.parseInt(numerator.replace("-", ""));
            else sum += Integer.parseInt(numerator);
        }

//        System.out.println(fractions);
//        System.out.println(commonDenominator);
        System.out.println(newFractions);
        System.out.println(sum + "/" + commonDenominator);


//        expression = expression.replace("+", "");
//        System.out.println(expression);


        return null;
    }

}
