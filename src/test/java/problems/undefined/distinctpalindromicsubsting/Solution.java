package problems.undefined.distinctpalindromicsubsting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class Solution {

    @Test
    public void d() {

//        ArrayList<String> ans = new ArrayList<>();
//        ans.add("a");
//        ans.add("aa");
//        ans.add("aaa");
//        ans.add("aba");
//        ans.add("b");

        assertEquals(6, countSubstrings("aaa"));

    }

    public String modifyString(String s) {

        StringBuilder sb = new StringBuilder("#");

        for (char c : s.toCharArray()) {
            sb.append(c).append('#');
        }

        return sb.toString();
    }

    public int countSubstrings(String s) {

        Set<String> set = new HashSet<>();

        if (s == null || s.length() == 0) return 0;

        String str = modifyString(s);
        int N = str.length();

        // for longest palindrome
        int centre = 0;
        int rightBoundary = 0;
        int count = 0;

        int[] substringLength = new int[N];

        for (int i = 0; i < N; i++) {

            int mirror = 2 * centre - i;

            if (i < rightBoundary) {
                // either expand all the way to the right boundary or take your mirrors length!
                int minLength = Math.min(substringLength[mirror], rightBoundary - i);
                substringLength[i] = minLength;
            }

            int left = i - 1 + substringLength[i];
            int right = i + 1 + substringLength[i];

            while (left >= 0 && right < N && str.charAt(left) == str.charAt(right)) {
                substringLength[i]++;
                left--;
                right++;
            }

            if (i + substringLength[i] > rightBoundary) {
                centre = i;
                rightBoundary = i + substringLength[i];
            }

            if (substringLength[i] % 2 == 0)
                count += substringLength[i] / 2;
            else
                count += (substringLength[i] / 2) + 1;
        }

        for (int l : substringLength) {

        }

        return count;
    }


//    public int countSubstrings(String s) {
//
//        Set<String> set = new HashSet<>();
//
//        if (s == null || s.length() == 0) return 0;
//        String T = modifyString(s);
//        //manachers algorithm
//        int C = 0, R = 0, count = 0;
//        int[] P = new int[T.length()];
//        for (int i = 1; i < T.length() - 1; i++) {
//            int mirror_i = C * 2 - i;
//            P[i] = (i < R) ? Math.min(R - i, P[mirror_i]) : 0;
//            while (i + 1 + P[i] < T.length() && i - 1 - P[i] >= 0 && T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
//                P[i]++;
//
//            }
//
//            if (i + P[i] > R) {
//                C = i;
//                R = i + P[i];
//            }
//
//            if (P[i] % 2 != 0)
//                count += P[i] / 2 + 1;
//            else
//                count += P[i] / 2;
//        }
//
//        return count;
//    }
}
