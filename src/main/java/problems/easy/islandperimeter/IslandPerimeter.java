package problems.easy.islandperimeter;

public class IslandPerimeter {


    public int islandPerimeter(int[][] grid) {
        if (grid == null) return 0;

        int total = 0;
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;

        for (int row = 0; row < numberOfRows; row++)
            for (int column = 0; column < numberOfColumns; column++)
                if (doesLandExist(grid, row, column))
                    total += findPerimeter(grid, row, column);

        return total;
    }


    private int findPerimeter(int[][] grid, int staringRow, int startingColumn) {
        int count = 0;
        if (countLeft(grid, staringRow, startingColumn - 1)) count++;
        if (countRight(grid, staringRow, startingColumn + 1)) count++;
        if (countTop(grid, staringRow - 1, startingColumn)) count++;
        if (countBottom(grid, staringRow + 1, startingColumn)) count++;
        return count;
    }

    private boolean countLeft(int[][] grid, int staringRow, int leftOfStaringColumn) {
        return leftOfStaringColumn < 0 || !doesLandExist(grid, staringRow, leftOfStaringColumn);
    }

    private boolean countRight(int[][] grid, int staringRow, int rightOfStartingColumn) {
        return rightOfStartingColumn >= grid[0].length || !doesLandExist(grid, staringRow, rightOfStartingColumn);
    }

    private boolean countTop(int[][] grid, int rowAboveStartingRow, int startingColumn) {
        return rowAboveStartingRow < 0 || !doesLandExist(grid, rowAboveStartingRow, startingColumn);
    }

    private boolean countBottom(int[][] grid, int rowBelowStartingRow, int startingColumn) {
        return rowBelowStartingRow >= grid.length || !doesLandExist(grid, rowBelowStartingRow, startingColumn);
    }

    private boolean doesLandExist(int[][] grid, int row, int column) {
        return grid[row][column] == 1;
    }

}
