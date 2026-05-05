package hard;

// 3911. K-th Smallest Remaining Even Integer in Subarray Queries

import java.util.ArrayList;
import java.util.List;

public class Solution3911 {
    public int[] kthRemainingInteger(int[] nums, int[][] queries) {
        int n = nums.length;
        List<Integer> evenIndex = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if ((nums[i] & 1) == 0)
                evenIndex.add(i);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int k = q[2];
            int li = lowerBound(evenIndex, q[0]);
            int ri = lowerBound(evenIndex, q[1] + 1);

            int l = -1, r = ri - li;
            while (l + 1 < r) {
                int mid = (l + r) >>> 1;
                if (nums[evenIndex.get(li + mid)] / 2 - (mid + 1) >= k)
                    r = mid;
                else
                    l = mid;
            }
            ans[i] = (r + k) * 2;
        }
        return ans;
    }
    
    private int lowerBound(List<Integer> arr, int target) {
        int l = -1, r = arr.size();
        while (l + 1 < r) {
            int mid = (l + r) >>> 1;
            if (arr.get(mid) >= target)
                r = mid;
            else
                l = mid;
        }
        return r;
    }
}
