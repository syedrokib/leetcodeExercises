package problems.easy.floodfill;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // check if starting pixel's color differs from newColor
        if (image[sr][sc] == newColor) return image;

        System.out.println(image[sr].length);

        // change the color of source pixel and continue checking in 4 directions
        image[sr][sc] = newColor;

        if(hasPixelBelow(sr, image[sr]));
        if (hasPixelAbove(sr));
        if (hasPixelToTheRight(sc, image[sc]));
        if (hasPixelToTheLeft(sc));
        return null;
    }

    private boolean hasPixelToTheLeft(int sourceColumn) {
        return sourceColumn - 1 >= 0;
    }

    private boolean hasPixelToTheRight(int sc, int[] ints) {
        return sc + 1 < ints.length;
    }

    private boolean hasPixelAbove(int sourceRow) {
        return sourceRow - 1 >= 0;
    }

    private boolean hasPixelBelow(int sourceRow, int[] image) {
        return sourceRow + 1 < image.length;
    }
}
