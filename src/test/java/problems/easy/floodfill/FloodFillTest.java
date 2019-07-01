package problems.easy.floodfill;

import org.junit.Test;

import static org.junit.Assert.*;

public class FloodFillTest {

    @Test
    public void floodFill() {
        assertNull(new FloodFill().floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2));
    }
}