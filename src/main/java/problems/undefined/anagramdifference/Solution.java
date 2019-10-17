package problems.undefined.anagramdifference;

public class Solution {

    public int difference(String s, String t) {

        if (s.length() != t.length()) return -1;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;


        int num = 0;
        for (int j = 0; j < t.length(); j++) {
            int index = t.charAt(j) - 'a';
            count[index]--;

            if (count[index] < 0) num++;
        }

        return num;
    }
}
