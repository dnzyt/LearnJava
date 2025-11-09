package medium;

// 3532. Path Existence Queries in a Graph I

import util.UnionFind;

public class Solution3532 {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        UnionFind uf = new UnionFind(n);
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n) {
                int l = lowerBound(nums, nums[j] + maxDiff);
                if (l == j + 1) {
                    j = l;
                    break;
                } else {
                    j = l - 1;
                }
            }
            for (int x = i; x < j; x++)
                uf.merge(i, x);
            i = j;
        }
        boolean[] ans = new boolean[queries.length];
        for (int k = 0; k < queries.length; k++)
            ans[k] = uf.find(queries[k][0]) == uf.find(queries[k][1]);

        return ans;
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
