package problems.medium;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.max;

//https://leetcode.com/problems/fraction-addition-and-subtraction/
class FractionAddition {
    static String fractionAddition(String expression) {

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

        List<String> unifiedFractions = new ArrayList<>();

        for (String fraction : fractions) {
            String numerator = fraction.split("[/]")[0];
            String denominator = fraction.split("[/]")[1];

            int ratio = commonDenominator / Integer.valueOf(denominator);

            if (numerator.startsWith("-")) {
                unifiedFractions.add("-" + Integer.parseInt(numerator.replace("-", "")) * ratio + "/" + commonDenominator);
            } else {
                unifiedFractions.add(Integer.parseInt(numerator) * ratio + "/" + commonDenominator);
            }
        }

        int numeratorSum = 0;
        for (String fraction : unifiedFractions) {

            String numerator = fraction.split("[/]")[0];

            if (numerator.startsWith("-")) numeratorSum -= Integer.parseInt(numerator.replace("-", ""));
            else numeratorSum += Integer.parseInt(numerator);
        }

        int reductionFactor = 1;
        for (int i = 1; i <= max(commonDenominator, numeratorSum); i++)
            if (commonDenominator % i == 0 && numeratorSum % i == 0) reductionFactor = i;

        numeratorSum /= reductionFactor;
        commonDenominator /= reductionFactor;

        return numeratorSum + "/" + commonDenominator;
    }

}
