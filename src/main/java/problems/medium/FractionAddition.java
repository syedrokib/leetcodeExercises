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


//            System.out.println(token);
        }

        System.out.println(fractions);


//        expression = expression.replace("+", "");
//        System.out.println(expression);


        return null;
    }

}
