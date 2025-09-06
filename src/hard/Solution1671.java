package hard;

import java.util.ArrayList;
import java.util.List;

public class Solution1671 {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] l = lis(nums);
        reverse(nums);
        int[] r = lis(nums);
        reverse(r);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            if (l[i] == 1 || r[i] == 1) continue;
            ans = Math.min(ans, n - l[i] - r[i] + 1);
        }
        return ans;
    }

    private int[] lis(int[] nums) {
        int n = nums.length;
        List<Integer> g = new ArrayList<Integer>();

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = lowerBound(g, nums[i]);
            if (idx == g.size())
                g.add(nums[i]);
            else
                g.set(idx, nums[i]);
            ans[i] = idx + 1;
        }
        return ans;

    }

    private int lowerBound(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums.get(mid) >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private void reverse(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
