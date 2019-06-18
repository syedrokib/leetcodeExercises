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
    private static final String FRACTION_PATTERN = "[-+][\\d]+[/][\\d]+";

    static String fractionAddition(String expression) {

        if (startsWithPositiveFraction(expression)) expression = PLUS_SIGN + expression;

        List<int[]> fractions = new ArrayList<>();
        Matcher m = Pattern.compile(FRACTION_PATTERN).matcher(expression);
        while (m.find()) {
            String[] tokens = m.group().split("/");
            int numerator = Integer.parseInt(tokens[0]);
            int denominator = Integer.parseInt(tokens[1]);
            fractions.add(new int[]{numerator, denominator});
        }

        int gcd = 1;
        for (int[] fraction : fractions) {
            int denominator = fraction[1];
            gcd *= denominator;
        }

        int numeratorSum = 0;
        for (int[] fraction : fractions) {
            int numerator = fraction[0];
            int denominator = fraction[1];
            numeratorSum += numerator * (gcd / denominator);
        }

        int reductionFactor = 1;
        for (int i = 1; i <= max(gcd, numeratorSum); i++) {
            if (gcd % i == 0 && numeratorSum % i == 0) reductionFactor = i;
        }

        numeratorSum /= reductionFactor;
        gcd /= reductionFactor;
        return numeratorSum + "/" + gcd;
    }

    private static boolean startsWithPositiveFraction(String expression) {
        return !expression.startsWith(MINUS_SIGN);
    }

}
