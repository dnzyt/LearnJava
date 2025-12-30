package easy;

// 812. Largest Triangle Area

public class Solution812 {
    public double largestTriangleArea(int[][] points) {
        int ans = 0;
        int n = points.length;
        for (int i = 0; i < n - 2; i++) {
            int[] a = points[i];
            for (int j = i + 1; j < n - 1; j++) {
                int[] b = points[j];
                for (int k = j + 1; k < n; k++) {
                    int[] c = points[k];
                    ans = Math.max(ans, area(a, b, c));
                }
            }
        }
        return ans / 2.0;
    }

    private int area(int[] a, int[] b, int[] c) {
        int[] ab = new int[]{b[0] - a[0], b[1] - a[1]};
        int[] bc = new int[]{c[0] - a[0], c[1] - a[1]};
        return Math.abs(ab[0] * bc[1] - ab[1] * bc[0]);
    }
}
