package medium;

// 2907. Maximum Profitable Triplets With Increasing Prices I

import util.SegmentTree;

import java.util.*;

public class Solution2907 {

    public int maxProfit(int[] prices, int[] profits) {
        int n = prices.length;
        int[] preMax = new int[n];
        Arrays.fill(preMax, -1);
        int[] postMax = new int[n];
        Arrays.fill(postMax, -1);

        HashSet<Integer> p = new HashSet<>();
        for (Integer x : prices) {
            p.add(x);
        }
        int m = p.size();
        List<Integer> price = new ArrayList<>(p);
        Collections.sort(price);
        HashMap<Integer, Integer> val2Idx = new HashMap<>();
        for (int i = 0; i < m; i++)
            val2Idx.put(price.get(i), i);
        int[] origin = new int[m];
        Arrays.fill(origin, -1);
        SegmentTree tree1 = new SegmentTree(origin);
        SegmentTree tree2 = new SegmentTree(origin);

        for (int i = 0; i < n; i++) {
            int idx = val2Idx.get(prices[i]);
            preMax[i] = tree1.queryRange(0, idx - 1);
            if (profits[i] > tree1.queryAt(idx))
                tree1.updateAt(idx, profits[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            int idx = val2Idx.get(prices[i]);
            postMax[i] = tree2.queryRange(idx + 1, m - 1);
            if (profits[i] > tree2.queryAt(idx))
                tree2.updateAt(idx, profits[i]);
        }

        int res = -1;
        for (int i = 0; i < n; i++) {
            if (preMax[i] > 0 && postMax[i] > 0)
                res = Math.max(res, preMax[i] + profits[i] + postMax[i]);
        }
        return res;


    }
}
