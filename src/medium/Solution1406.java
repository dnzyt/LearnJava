package medium;

// 1406. Stone Game III

public class Solution1406 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] f = new int[n + 3];
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += stoneValue[i];
            f[i] = sum - Math.min(f[i + 1], Math.min(f[i + 2], f[i + 3]));
        }
        int diff = f[0] - (sum - f[0]);
        if (diff == 0)
            return "Tie";
        return diff > 0 ? "Alice" : "Bob";
    }
}
