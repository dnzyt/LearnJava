package medium;

// 3809. Best Reachable Tower

public class Solution3809 {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int cx = center[0], cy = center[1];
        int maxQ = -1, minX = -1, minY = -1;
        for (int[] t : towers) {
            int x = t[0], y = t[1], q = t[2];
            if (Math.abs(x - cx) + Math.abs(y - cy) <= radius &&
                    (maxQ < q || maxQ == q && (x < minX || x == minX && y < minY))) {
                maxQ = q;
                minX = x;
                minY = y;
            }
        }
        return new int[]{minX, minY};
    }
}
