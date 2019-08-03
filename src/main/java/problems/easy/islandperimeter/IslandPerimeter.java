package problems.easy.islandperimeter;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {

        // you add 3 except for the side that you share

        int startingRow = -1;
        int startingColumn = -1;

        boolean isStartDetermined = false;
        int gridRowLength = grid.length;
        int gridColumnLength = grid[0].length;

        boolean[][] visitedGrid = new boolean[gridRowLength][gridColumnLength];

        for (int row = 0; row < gridRowLength; row++) {
            for (int column = 0; column < gridColumnLength; column++) {
                visitedGrid[row][column] = false;
                if (!isStartDetermined && grid[row][column] == 1) {
                    startingRow = row;
                    startingColumn = column;
                    isStartDetermined = true;
                }
            }
        }

        return findPerimeter(grid, startingRow, startingColumn, 4, visitedGrid);

    }

    private int findPerimeter(int[][] grid, int startingRow, int startingColumn, int totalPerimeter,
                              boolean[][] visitedGrid) {

        visitedGrid[startingRow][startingColumn] = true;

        //keep track of visited nodes

        //check bounds && check for node existence && check for not visited


        boolean hasLeft = (startingColumn - 1 >= 0) && (!visitedGrid[startingRow][startingColumn - 1]) && (grid[startingRow][startingColumn - 1] == 1);
        boolean hasRight = (startingColumn + 1 < grid[0].length) && (!visitedGrid[startingRow][startingColumn + 1]) && (grid[startingRow][startingColumn + 1] == 1);
        boolean hasTop = (startingRow - 1 >= 0) && (!visitedGrid[startingRow - 1][startingColumn]) && (grid[startingRow - 1][startingColumn] == 1);
        boolean hasBottom = (startingRow + 1 < grid.length) && (!visitedGrid[startingRow - 1][startingColumn]) && (grid[startingRow - 1][startingColumn] == 1);

        if (hasLeft) totalPerimeter = findPerimeter(grid, startingRow, startingColumn - 1, 2 + totalPerimeter, visitedGrid);

        return 0;
    }

}
