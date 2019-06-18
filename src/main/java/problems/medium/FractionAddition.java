package problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Float.max;

//https://leetcode.com/problems/fraction-addition-and-subtraction/
class FractionAddition {

    private static final String PLUS_SIGN = "+";
    private static final String MINUS_SIGN = "-";

    static String fractionAddition(String expression) {

        if (!expression.startsWith(MINUS_SIGN)) expression = PLUS_SIGN + expression;

        List<String> fractions = new ArrayList<>();
        Matcher m = Pattern.compile("[-+][\\d]+[/][\\d]+").matcher(expression);
        while (m.find()) fractions.add(m.group());

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

            if (numerator.startsWith(MINUS_SIGN)) {
                unifiedFractions.add(MINUS_SIGN + Integer.parseInt(numerator.replace(MINUS_SIGN, "")) * ratio + "/" + commonDenominator);
            } else {
                unifiedFractions.add(Integer.parseInt(numerator) * ratio + "/" + commonDenominator);
            }
        }

        int numeratorSum = 0;
        for (String fraction : unifiedFractions) {

            String numerator = fraction.split("[/]")[0];

            if (numerator.startsWith(MINUS_SIGN)) numeratorSum -= Integer.parseInt(numerator.replace(MINUS_SIGN, ""));
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
