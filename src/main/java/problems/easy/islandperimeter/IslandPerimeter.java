package problems.easy.islandperimeter;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {

        // you add 3 except for the side that you share

        int startingRow = -1;
        int startingColumn = -1;


        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == 1) {
                    startingRow = row;
                    startingColumn = column;
                    break;
                }
            }
        }

        return findPerimeter(grid, startingRow, startingColumn, 4);





    }

    private int findPerimeter(int[][] grid, int startingRow, int startingColumn, int totalPerimeter) {

        return 0;
    }

}
