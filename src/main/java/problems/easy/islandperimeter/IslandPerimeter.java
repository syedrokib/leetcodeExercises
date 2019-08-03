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

        int leftColumnIndex = startingColumn - 1;
        int rightColumnIndex = startingColumn + 1;
        int topRowIndex = startingRow - 1;
        int bottomRowIndex = startingRow + 1;

        boolean hasLeft = (leftColumnIndex >= 0) && (!visitedGrid[startingRow][leftColumnIndex]) && (grid[startingRow][leftColumnIndex] == 1);
        boolean hasRight = (rightColumnIndex < grid[0].length) && (!visitedGrid[startingRow][rightColumnIndex]) && (grid[startingRow][rightColumnIndex] == 1);
        boolean hasTop = (topRowIndex >= 0) && (!visitedGrid[topRowIndex][startingColumn]) && (grid[topRowIndex][startingColumn] == 1);
        boolean hasBottom = (bottomRowIndex < grid.length) && (!visitedGrid[bottomRowIndex][startingColumn]) && (grid[bottomRowIndex][startingColumn] == 1);

        if (hasLeft)
            totalPerimeter = findPerimeter(grid, startingRow, leftColumnIndex, 2 + totalPerimeter, visitedGrid);
        if (hasRight)
            totalPerimeter = findPerimeter(grid, startingRow, rightColumnIndex, 2 + totalPerimeter, visitedGrid);
        if (hasTop)
            totalPerimeter = findPerimeter(grid, topRowIndex, startingColumn, 2 + totalPerimeter, visitedGrid);
        if (hasBottom)
            totalPerimeter = findPerimeter(grid, bottomRowIndex, startingColumn, 2 + totalPerimeter, visitedGrid);

        return totalPerimeter;
    }

}
