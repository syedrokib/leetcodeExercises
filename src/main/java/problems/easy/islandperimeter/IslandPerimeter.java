package problems.easy.islandperimeter;

public class IslandPerimeter {


    public int islandPerimeter(int[][] grid) {

        int total = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    total += findPerimeter(grid, i, j);
                }

            }
        }
        return total;
    }


    private int findPerimeter(int[][] grid, int row, int col) {
        int count = 0;
        if (col - 1 < 0 || grid[row][col - 1] == 0) count++;
        if (col + 1 >= grid[0].length || grid[row][col + 1] == 0) count++;
        if (row - 1 < 0 || grid[row - 1][col] == 0) count++;
        if (row + 1 >= grid.length || grid[row + 1][col] == 0) count++;
        return count;
    }
}
