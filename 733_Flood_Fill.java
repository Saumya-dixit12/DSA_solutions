class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int originalColor = image[sr][sc];

        // Already same color
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int color) {
        
        // Boundary check
        if (r < 0 || r >= image.length ||
            c < 0 || c >= image[0].length) {
            return;
        }

        // Only fill original-color cells
        if (image[r][c] != originalColor) {
            return;
        }

        // Change color
        image[r][c] = color;

        // 4 directions
        dfs(image, r - 1, c, originalColor, color); // up
        dfs(image, r + 1, c, originalColor, color); // down
        dfs(image, r, c - 1, originalColor, color); // left
        dfs(image, r, c + 1, originalColor, color); // right
    }
}
