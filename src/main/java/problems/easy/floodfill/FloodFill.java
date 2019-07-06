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

        // mark as visited
        visitedPixels.get(sr).set(sc, true);

        int sourceColor = image[sr][sc];

        // change the color of source pixel and continue checking in 4 directions
        image[sr][sc] = newColor;

        int bottomPixel = sr + 1;
        int topPixel = sr - 1;
        int rightPixel = sc + 1;
        int leftPixel = sc - 1;

        boolean isBottomFillRequired = (bottomPixel < image[sr].length) && (image[bottomPixel][sc] == sourceColor) && (!visitedPixels.get(bottomPixel).get(sc));
        boolean isTopFillRequired = (topPixel >= 0) && (image[topPixel][sc] == sourceColor) && (!visitedPixels.get(topPixel).get(sc));
        boolean isRightFillRequired = (rightPixel < image[sc].length) && (image[sr][rightPixel] == sourceColor) && (!visitedPixels.get(sr).get(rightPixel));
        boolean isLeftFillRequired = (leftPixel >= 0) && (image[sr][leftPixel] == sourceColor) && (!visitedPixels.get(sr).get(leftPixel));

        if (isBottomFillRequired) image = floodFillRecursively(image, bottomPixel, sc, newColor, visitedPixels);
        if (isTopFillRequired) image = floodFillRecursively(image, topPixel, sc, newColor, visitedPixels);
        if (isRightFillRequired) image = floodFillRecursively(image, sr, rightPixel, newColor, visitedPixels);
        if (isLeftFillRequired) image = floodFillRecursively(image, sr, leftPixel, newColor, visitedPixels);

        return image;
    }
}
