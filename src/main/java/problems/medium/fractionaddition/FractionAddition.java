package problems.medium.fractionaddition;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.lang.Float.max;

//https://leetcode.com/problems/fraction-addition-and-subtraction/
class FractionAddition {

    private static final String PLUS_SIGN = "+";
    private static final String MINUS_SIGN = "-";
    private static final String FRACTION_PATTERN = "[-+][\\d]+[/][\\d]+";

    static String fractionAddition(String expression) {

        List<Integer> numerator = new ArrayList<>();
        List<Integer> denominator = new ArrayList<>();
        Matcher m = Pattern.compile(FRACTION_PATTERN).matcher(formatExpression(expression));
        while (m.find()) {
            String[] tokens = m.group().split("/");
            numerator.add(Integer.parseInt(tokens[0]));
            denominator.add(Integer.parseInt(tokens[1]));
        }

        int gcd = denominator.stream().reduce(1, (a, b) -> a * b);
        int sum = 0;
        for (int i = 0; i < numerator.size(); i++) sum += numerator.get(i) * (gcd / denominator.get(i));


        int simplificationFactor = 1;
        float max = max(gcd, sum);
        for (int i = 1; i <= max; i++) if (gcd % i == 0 && sum % i == 0) simplificationFactor = i;

        return (sum / simplificationFactor) + "/" + (gcd / simplificationFactor);
    }

    private static String formatExpression(String expression) {
        return expression.startsWith(MINUS_SIGN) ? expression : PLUS_SIGN + expression;
    }

}
