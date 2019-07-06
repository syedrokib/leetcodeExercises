package problems.easy.floodfill;

import java.util.ArrayList;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // check if starting pixel's color differs from newColor
        if (image[sr][sc] == newColor) return image;

        ArrayList<ArrayList<Boolean>> visitedPixels = new ArrayList<>();
        for (int[] array : image) {
            ArrayList<Boolean> visitedInitializer = new ArrayList<>();
            for (int ignored : array) visitedInitializer.add(false);
            visitedPixels.add(visitedInitializer);
        }

        return floodFillRecursively(image, sr, sc, newColor, visitedPixels);
    }

    private int[][] floodFillRecursively(int[][] image, int sr, int sc, int newColor, ArrayList<ArrayList<Boolean>> visitedPixels) {
        int sourceColor = image[sr][sc];
        markAsVisited(sr, sc, visitedPixels);
        image[sr][sc] = newColor;

        int bottomRow = sr + 1;
        int topPixel = sr - 1;
        int rightColumn = sc + 1;
        int leftColumn = sc - 1;

        boolean bottomFillRequired = isBottomFillRequired(bottomRow, image, sr, sc, sourceColor, visitedPixels);
        boolean topFillRequired = isTopFillRequired(topPixel, image, sc, sourceColor, visitedPixels);
        boolean rightFillRequired = isRightFillRequired(rightColumn, image, sr, sc, sourceColor, visitedPixels);
        boolean leftFillRequired = isLeftFillRequired(leftColumn, image, sr, sourceColor, visitedPixels);

        if (bottomFillRequired) image = floodFillRecursively(image, bottomRow, sc, newColor, visitedPixels);
        if (topFillRequired) image = floodFillRecursively(image, topPixel, sc, newColor, visitedPixels);
        if (rightFillRequired) image = floodFillRecursively(image, sr, rightColumn, newColor, visitedPixels);
        if (leftFillRequired) image = floodFillRecursively(image, sr, leftColumn, newColor, visitedPixels);

        return image;
    }

    private void markAsVisited(int sr, int sc, ArrayList<ArrayList<Boolean>> visitedPixels) {
        visitedPixels.get(sr).set(sc, true);
    }

    private boolean isBottomFillRequired(int bottomRow, int[][] image, int sourceRow, int sourceColumn, int sourceColor,
                                         ArrayList<ArrayList<Boolean>> visitedPixels) {
        return isInBounds(bottomRow, image[sourceRow]) && !isPixelVisited(visitedPixels, bottomRow, sourceColumn)
                && doesMatch(sourceColor, image[bottomRow][sourceColumn]);
    }

    private boolean isTopFillRequired(int topRow, int[][] image, int sourceColumn, int sourceColor,
                                      ArrayList<ArrayList<Boolean>> visitedPixels) {
        return isInBounds(topRow) && !isPixelVisited(visitedPixels, topRow, sourceColumn) &&
                doesMatch(sourceColor, image[topRow][sourceColumn]);
    }

    private boolean isRightFillRequired(int rightColumn, int[][] image, int sourceRow, int sourceColumn, int sourceColor,
                                        ArrayList<ArrayList<Boolean>> visitedPixels) {
        return isInBounds(rightColumn, image[sourceColumn]) && !isPixelVisited(visitedPixels, sourceRow, rightColumn)
                && doesMatch(sourceColor, image[sourceRow][rightColumn]);
    }

    private boolean isLeftFillRequired(int leftColumn, int[][] image, int sourceRow, int sourceColor,
                                       ArrayList<ArrayList<Boolean>> visitedPixels) {
        return isInBounds(leftColumn) && !isPixelVisited(visitedPixels, sourceRow, leftColumn)
                && doesMatch(sourceColor, image[sourceRow][leftColumn]);
    }

    private boolean isInBounds(int index) {
        return index >= 0;
    }

    private Boolean isPixelVisited(ArrayList<ArrayList<Boolean>> visitedPixels, int row, int column) {
        return visitedPixels.get(row).get(column);
    }

    private boolean doesMatch(int sourceColor, int pixelColor) {
        return sourceColor == pixelColor;
    }

    private boolean isInBounds(int index, int[] imageEntity) {
        return index < imageEntity.length;
    }
}
