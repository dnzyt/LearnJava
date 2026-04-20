package hard;

// 952. Largest Component Size by Common Factor


import java.util.Arrays;

public class Solution952 {
    private static final int MX = 100000;
    private int[] parent;
    private int[] size;

    public int largestComponentSize(int[] nums) {
        int[] lpf = new int[MX + 1]; // Least Prime Factor
        lpf[1] = 1;
        for (int i = 2; i <= MX; i++) {
            if (lpf[i] == 0)
                lpf[i] = i;
            for (int j = i * i; j > 0 && j <= MX; j += i)
                if (lpf[j] == 0)
                    lpf[j] = i;
        }
        parent = new int[MX * 2 + 1];
        size = new int[MX * 2 + 1];
        Arrays.fill(size, 0, MX, 1);
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            while (x > 1) {
                int p = lpf[x];
                while (p == lpf[x])
                    x /= p;
                merge(p + MX, i);
            }
            ans = Math.max(ans, size[find(i)]);
        }
        return ans;
    }

    private int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean merge(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py)
            return false;
        parent[px] = py;
        size[py] += size[px];
        return true;
    }
}
