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
        markSourceAsVisited(sr, sc, visitedPixels);
        image[sr][sc] = newColor;

        boolean bottomFillRequired = isBottomFillRequired(sr + 1, image, sr, sc, sourceColor, visitedPixels);
        boolean topFillRequired = isTopFillRequired(sr - 1, image, sc, sourceColor, visitedPixels);
        boolean rightFillRequired = isRightFillRequired(sc + 1, image, sr, sc, sourceColor, visitedPixels);
        boolean leftFillRequired = isLeftFillRequired(sc - 1, image, sr, sourceColor, visitedPixels);

        if (bottomFillRequired) image = floodFillRecursively(image, sr + 1, sc, newColor, visitedPixels);
        if (topFillRequired) image = floodFillRecursively(image, sr - 1, sc, newColor, visitedPixels);
        if (rightFillRequired) image = floodFillRecursively(image, sr, sc + 1, newColor, visitedPixels);
        if (leftFillRequired) image = floodFillRecursively(image, sr, sc - 1, newColor, visitedPixels);

        return image;
    }

    private boolean isBottomFillRequired(int bottomRow, int[][] image, int sourceRow, int sourceColumn, int sourceColor,
                                         ArrayList<ArrayList<Boolean>> visitedPixels) {
        return isInBounds(bottomRow, image[sourceRow]) && !isPixelVisited(bottomRow, sourceColumn, visitedPixels)
                && doesMatch(sourceColor, image[bottomRow][sourceColumn]);
    }

    private boolean isTopFillRequired(int topRow, int[][] image, int sourceColumn, int sourceColor,
                                      ArrayList<ArrayList<Boolean>> visitedPixels) {
        return isInBounds(topRow) && !isPixelVisited(topRow, sourceColumn, visitedPixels) &&
                doesMatch(sourceColor, image[topRow][sourceColumn]);
    }

    private boolean isRightFillRequired(int rightColumn, int[][] image, int sourceRow, int sourceColumn, int sourceColor,
                                        ArrayList<ArrayList<Boolean>> visitedPixels) {
        return isInBounds(rightColumn, image[sourceColumn]) && !isPixelVisited(sourceRow, rightColumn, visitedPixels)
                && doesMatch(sourceColor, image[sourceRow][rightColumn]);
    }

    private boolean isLeftFillRequired(int leftColumn, int[][] image, int sourceRow, int sourceColor,
                                       ArrayList<ArrayList<Boolean>> visitedPixels) {
        return isInBounds(leftColumn) && !isPixelVisited(sourceRow, leftColumn, visitedPixels)
                && doesMatch(sourceColor, image[sourceRow][leftColumn]);
    }

    private boolean isInBounds(int index, int[] imageEntity) {
        return index < imageEntity.length;
    }

    private boolean isInBounds(int index) {
        return index >= 0;
    }

    private Boolean isPixelVisited(int row, int column, ArrayList<ArrayList<Boolean>> visitedPixels) {
        return visitedPixels.get(row).get(column);
    }

    private boolean doesMatch(int sourceColor, int pixelColor) {
        return sourceColor == pixelColor;
    }

    private void markSourceAsVisited(int sr, int sc, ArrayList<ArrayList<Boolean>> visitedPixels) {
        visitedPixels.get(sr).set(sc, true);
    }
}
