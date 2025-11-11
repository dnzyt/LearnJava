package medium;

// 3551. Minimum Swaps to Sort by Digit Sum

import util.UnionFind;

import java.util.*;

public class Solution3551 {
    public int minSwaps(int[] nums) {
        List<int[]> digitSums = new ArrayList<>();
        Map<Integer, Integer> numToIdx = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int ds = 0;
            int num = nums[i];
            numToIdx.put(num, i);
            while (num != 0) {
                ds += (num % 10);
                num /= 10;
            }
            digitSums.add(new int[]{ds, nums[i]});
        }
        digitSums.sort(Comparator.<int[]>comparingInt(a -> a[0]).thenComparing(a -> a[1]));
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            uf.merge(i, numToIdx.get(digitSums.get(i)[1]));
        }

        return n - uf.count;
    }
}
