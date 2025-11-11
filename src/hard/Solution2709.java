package hard;

// 2709. Greatest Common Divisor Traversal

import util.UnionFind;

public class Solution2709 {
    private static final int MX = 100001;

    public boolean canTraverseAllPairs(int[] nums) {
        int[] lpf = new int[MX + 1];
        for (int i = 2; i <= MX; i++) {
            if (lpf[i] > 0) continue;
            for (int j = i; j <= MX; j += i) {
                if (lpf[j] > 0) continue;
                lpf[j] = i;
            }
        }

        int n = nums.length;
        UnionFind uf = new UnionFind(n + MX);
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (x > 1) {
                int p = lpf[x];
                while (p == lpf[x])
                    x /= p;
                uf.merge(i, n + p);
            }
        }
        int x = uf.find(0);
        for (int i = 1; i < n; i++) {
            if (uf.find(i) != x)
                return false;
        }
        return true;
    }

}
