package easy;

// 832. Flipping an Image

public class Solution832 {
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length, n = image[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int t = image[i][j];
                image[i][j] = image[i][n - 1 - j] == 0 ? 1 : 0;
                if (n % 2 == 1 && j == n / 2) continue;
                image[i][n - 1 - j] = t == 0 ? 1 : 0;
            }
        }
        return image;
    }
}
