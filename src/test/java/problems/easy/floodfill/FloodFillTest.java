package problems.easy.floodfill;

import org.junit.Test;

import static org.junit.Assert.*;

public class FloodFillTest {

    private final FloodFill f = new FloodFill();

    @Test
    public void floodFill() {
        assertArrayEquals(new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}},
                f.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2));

        assertArrayEquals(new int[][]{{2, 2, 2}, {2, 2, 2}},
                f.floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 2));
    }
}