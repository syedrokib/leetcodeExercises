package problems.easy.islandperimeter;

import org.junit.Test;

import static org.junit.Assert.*;

public class IslandPerimeterTest {
    IslandPerimeter i = new IslandPerimeter();

    @Test
    public void islandPerimeter() {
        assertEquals(0, i.islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
}
}