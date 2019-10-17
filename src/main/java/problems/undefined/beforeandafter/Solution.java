package problems.undefined.beforeandafter;

import java.util.*;

public class Solution {

    public List<String> beforeAndAfter(List<String> phrases) {

        Map<Integer, AbstractMap.SimpleEntry<String, String>> map = new HashMap<>();

        String x = "hello";
        char x1 = x.charAt(x.length() - 1);
        char x2 = x.charAt(x.length() - 2);

        String x3 = String.format("%c %c", x1, x2);
        System.out.println(x3);


        for (int i = 0; i < phrases.size(); i++) {

            String phrase = phrases.get(i);
            int firstSpace = phrase.indexOf(' ');
            int lastSpace = phrase.lastIndexOf(' ');

            String head = phrase.substring(0, firstSpace);
            String tail = phrase.substring(lastSpace + 1);
            map.put(i, new AbstractMap.SimpleEntry<>(head, tail));
        }

//        System.out.println(map);

        Set<String> answerSet = new HashSet<>();

        for (int i = 0; i < phrases.size(); i++) {

            String firstWord = map.get(i).getKey();

            for (Map.Entry<Integer, AbstractMap.SimpleEntry<String, String>> entry : map.entrySet()) {

                if (entry.getKey() == i) continue;

                String lastWord = entry.getValue().getValue();
                if (firstWord.equals(lastWord)) {
                    String first = phrases.get(entry.getKey());
                    first = first.replace(lastWord, "");
                    String last = phrases.get(i);
                    answerSet.add(first + last);
                }
            }
        }
        ArrayList<String> strings = new ArrayList<>(answerSet);
        Collections.sort(strings);
        return strings;
    }
}
