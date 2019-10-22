package problems.undefined.longestpalindromicsubstring;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class Solution {

    @Test
    public void name() {
//        assertEquals("adddddddddddddddda",findLongestPalindrome("babbababababbadddddddddddddddda"));
        int length = "babbababababbadddddddddddddddda".length();
        assertEquals(18,manachersAlgorithm("babbababababbadddddddddddddddda", length));

    }

    int manachersAlgorithm(String s, int N) {
        String str = getModifiedString(s, N);
        int len = (2 * N) + 1;
        int[] P = new int[len];
        int c = 0; //stores the center of the longest palindromic substring until now
        int r = 0; //stores the right boundary of the longest palindromic substring until now
        int maxLen = 0;
        for(int i = 0; i < len; i++) {
            //get mirror index of i
            int mirror = (2 * c) - i;

            //see if the mirror of i is expanding beyond the left boundary of current longest palindrome at center c
            //if it is, then take r - i as P[i]
            //else take P[mirror] as P[i]
            if(i < r) {
                P[i] = Math.min(r - i, P[mirror]);
            }

            //expand at i
            int a = i + (1 + P[i]);
            int b = i - (1 + P[i]);
            while(a < len && b >= 0 && str.charAt(a) == str.charAt(b)) {
                P[i]++;
                a++;
                b--;
            }

            //check if the expanded palindrome at i is expanding beyond the right boundary of current longest palindrome at center c
            //if it is, the new center is i
            if(i + P[i] > r) {
                c = i;
                r = i + P[i];

                if(P[i] > maxLen) { //update maxlen
                    maxLen = P[i];
                }
            }
        }
        return maxLen;
    }

    String getModifiedString(String s, int N){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }

    public static String findLongestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        char[] s2 = addBoundaries(s.toCharArray());
        int[] p = new int[s2.length];
        int c = 0, r = 0; // Here the first element in s2 has been processed.
        int m = 0, n = 0; // The walking indices to compare if two elements are the same.
        for (int i = 1; i < s2.length; i++) {
            if (i > r) {
                p[i] = 0;
                m = i - 1;
                n = i + 1;
            } else {
                int i2 = c * 2 - i;
                if (p[i2] < (r - i - 1)) {
                    p[i] = p[i2];
                    m = -1; // This signals bypassing the while loop below.
                } else {
                    p[i] = r - i;
                    n = r + 1;
                    m = i * 2 - n;
                }
            }
            while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
                p[i]++;
                m--;
                n++;
            }
            if ((i + p[i]) > r) {
                c = i;
                r = i + p[i];
            }
        }
        int len = 0;
        c = 0;
        for (int i = 1; i < s2.length; i++) {
            if (len < p[i]) {
                len = p[i];
                c = i;
            }
        }
        char[] ss = Arrays.copyOfRange(s2, c - len, c + len + 1);
        return String.valueOf(removeBoundaries(ss));
    }

    private static char[] addBoundaries(char[] cs) {
        if (cs == null || cs.length == 0)
            return "||".toCharArray();

        char[] cs2 = new char[cs.length * 2 + 1];
        for (int i = 0; i < (cs2.length - 1); i = i + 2) {
            cs2[i] = '|';
            cs2[i + 1] = cs[i / 2];
        }
        cs2[cs2.length - 1] = '|';
        return cs2;
    }

    private static char[] removeBoundaries(char[] cs) {
        if (cs == null || cs.length < 3)
            return "".toCharArray();

        char[] cs2 = new char[(cs.length - 1) / 2];
        for (int i = 0; i < cs2.length; i++) {
            cs2[i] = cs[i * 2 + 1];
        }
        return cs2;
    }

}
