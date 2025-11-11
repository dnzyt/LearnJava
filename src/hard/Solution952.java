package hard;

// 952. Largest Component Size by Common Factor

import util.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class Solution952 {
    private static final int MX = 100000;

    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        int[] lpf = new int[MX + 1];
        lpf[1] = 1;
        for (int i = 2; i <= MX; i++) {
            if (lpf[i] == 0) {
                lpf[i] = i;
                for (int j = i * i; j > 0 && j <= MX; j += i) {
                    if (lpf[j] == 0)
                        lpf[j] = i;
                }
            }
        }
        UnionFind uf = new UnionFind(n + MX);
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (x > 1) {
                int p = lpf[x];
                while (p == lpf[x])
                    x /= p;
                uf.merge(i, n + p); // merge的是索引
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(uf.find(i), 1, Integer::sum);
        }
        return map.values().stream().max(Integer::compareTo).get();
    }
}
