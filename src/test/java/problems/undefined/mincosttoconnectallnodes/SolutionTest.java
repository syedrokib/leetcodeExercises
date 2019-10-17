package problems.undefined.mincosttoconnectallnodes;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void name() {

        assertEquals(7, new Solution().minCostToConnectAllNodes(
                6,
                new int[][]{{1, 4}, {4, 5}, {2, 3}},
                new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}}));


        assertEquals(8, new Solution().minCostToConnectAllNodes(
                16,
                new int[][]{
                        {1, 5},
                        {2, 11},
                        {2, 12},
                        {2, 6},
                        {2, 8},
                        {3, 16},
                        {4, 12},
                        {5, 7},
                        {6, 8},
                        {9, 14},
                        {10, 11},
                        {13, 15},
                },
                new int[][]{
                        {3, 12, 2},
                        {5, 16, 4},
                        {7, 8, 4},
                        {7, 10, 3},
                        {12, 13, 6},
                        {14, 15, 2},
                        {14, 16, 1}
                }));
    }
}