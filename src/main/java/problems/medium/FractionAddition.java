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

        List<Fraction> fractions = new ArrayList<>();
        Matcher m = Pattern.compile(FRACTION_PATTERN).matcher(expression);
        while (m.find()) {
            String[] tokens = m.group().split("/");
            fractions.add(new Fraction(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
        }

        int gcd = 1;
        for (Fraction fraction : fractions) gcd *= fraction.denominator;

        int numeratorSum = 0;
        for (Fraction fraction : fractions) {
            numeratorSum += fraction.numerator * (gcd / fraction.denominator);
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

    static class Fraction {

        int numerator;
        int denominator;

        Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

}
