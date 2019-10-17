package problems.undefined.addwholenumbers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public int add(String expression) {

        ArrayList<Integer> numbers = new ArrayList<>();

        if (!expression.startsWith("-"))
            expression = "+" + expression;

        Matcher m = Pattern.compile("[-+][\\d]+").matcher(expression);

        while (m.find()) {
            numbers.add(Integer.valueOf(m.group()));
        }

        int total = 0;
        for (int i = 0; i < numbers.size(); i++) total += numbers.get(i);

        return total;
    }

}
