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

        if (startsWithPositiveFraction(expression)) expression = PLUS_SIGN + expression;

        List<int[]> fractions = new ArrayList<>();
        Matcher m = Pattern.compile("[-+][\\d]+[/][\\d]+").matcher(expression);
        while (m.find()) {
            String[] tokens = m.group().split("/");
            int numerator = Integer.parseInt(tokens[0]);
            int denominator = Integer.parseInt(tokens[1]);
            fractions.add(new int[]{numerator, denominator});
        }

        int commonDenominator = 1;
        for (int[] fraction : fractions) commonDenominator *= fraction[1];

        for (int[] fraction : fractions) {
            fraction[0] *= commonDenominator / fraction[1];
            fraction[1] = commonDenominator;
        }

        int numeratorSum = 0;
        for (int[] fraction : fractions) numeratorSum += fraction[0];

        int reductionFactor = 1;
        for (int i = 1; i <= max(commonDenominator, numeratorSum); i++) {
            if (commonDenominator % i == 0 && numeratorSum % i == 0) reductionFactor = i;
        }

        numeratorSum /= reductionFactor;
        commonDenominator /= reductionFactor;

        return numeratorSum + "/" + commonDenominator;
    }

    private static boolean startsWithPositiveFraction(String expression) {
        return !expression.startsWith(MINUS_SIGN);
    }

}
