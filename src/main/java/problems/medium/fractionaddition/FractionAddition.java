package problems.medium.fractionaddition;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Float.max;

//https://leetcode.com/problems/fraction-addition-and-subtraction/
class FractionAddition {

    private static final String PLUS_SIGN = "+";
    private static final String MINUS_SIGN = "-";
    private static final String FRACTION_PATTERN = "^([$]?|[@]{0,2})([a-zA-Z_]+[0-9a-zA-Z_]*)([^?!=])$";

    static String fractionAddition(String expression) {

        List<Integer> numerators = new ArrayList<>();
        List<Integer> denominators = new ArrayList<>();
        Matcher m = Pattern.compile(FRACTION_PATTERN).matcher(formatExpression(expression));
        while (m.find()) {
            String[] tokens = m.group().split("/");
            numerators.add(Integer.parseInt(tokens[0]));
            denominators.add(Integer.parseInt(tokens[1]));
        }

        int gcd = gcd(denominators);
        int sumOfNumerators = sumOfNumerators(numerators, denominators, gcd);
        int simplificationFactor = simplificationFactor(gcd, sumOfNumerators);

        return (sumOfNumerators / simplificationFactor) + "/" + (gcd / simplificationFactor);
    }

    private static int simplificationFactor(int gcd, int sumOfNumerators) {
        float max = max(gcd, sumOfNumerators);
        int simplificationFactor = 1;
        for (int i = 1; i <= max; i++) if (gcd % i == 0 && sumOfNumerators % i == 0) simplificationFactor = i;
        return simplificationFactor;
    }

    private static int sumOfNumerators(List<Integer> numerators, List<Integer> denominators, int gcd) {
        int sum = 0;
        for (int i = 0; i < numerators.size(); i++) sum += numerators.get(i) * (gcd / denominators.get(i));
        return sum;
    }

    private static Integer gcd(List<Integer> denominators) {
        return denominators.stream().reduce(1, (a, b) -> a * b);
    }

    private static String formatExpression(String expression) {
        return expression.startsWith(MINUS_SIGN) ? expression : PLUS_SIGN + expression;
    }

}
