package problems.undefined.numberofholes;

public class Solution {

    public int numberOfHoles(int number) {

        if (number == 0) return 1;
        int hole[] = {1, 0, 0, 0, 1, 0, 1, 0, 2, 1};

        int holes = 0;

        while (number > 0) {
            int digit = number % 10;
            holes += hole[digit];
            number /= 10;
        }

        return holes;
    }

}
