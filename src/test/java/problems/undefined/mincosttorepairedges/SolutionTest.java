package problems.undefined.mincosttorepairedges;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void name1() {

//        assertEquals(20, new Solution().minCostToRepairEdges(
//                5,
//                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}},
//                new int[][]{{1, 2, 12}, {3, 4, 30}, {1, 5, 8}}));
//
//
//        assertEquals(410, new Solution().minCostToRepairEdges(
//                6,
//                new int[][]{{1, 2}, {2, 3}, {4, 5}, {3, 5}, {1, 6}, {2, 4}},
//                new int[][]{{1, 6, 410}, {2, 4, 800}}));
//
//        assertEquals(79, new Solution().minCostToRepairEdges(
//                6,
//                new int[][]{{1, 2}, {2, 3}, {4, 5}, {5, 6}, {1, 5}, {2, 4}, {3, 4}},
//                new int[][]{{1, 5, 110}, {2, 4, 84}, {3, 4, 79}}));

        assertEquals(0, new Solution().minCostToRepairEdges(
                8,
                new int[][]{{1, 2}, {2, 3}, {4, 3}, {4, 5}, {5, 7}, {6, 7}, {7, 8}},
                new int[][]{{3, 8, 1}, {4, 7, 9}}));


    }
}