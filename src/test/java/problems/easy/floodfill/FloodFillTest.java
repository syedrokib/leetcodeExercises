package problems.easy.floodfill;

import org.junit.Test;

import static org.junit.Assert.*;

public class FloodFillTest {

    @Test
    public void floodFill() {
        assertNull(new FloodFill().floodFill(new int[0][0], 0, 0, 0));
        assertNull(new FloodFill().floodFill(new int[0][0], 0, 0, 0));
    }
}