package medium;

// 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1477 {
    // prefix sum + hashtable
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int minLen = n;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target))
                minLen = Math.min(minLen, i - map.get(sum - target));
            left[i] = minLen;
            map.put(sum, i);
        }

        sum = 0;
        minLen = n;
        map.clear();
        map.put(0, n);
        for (int i = n - 1; i >= 0; i--) {
            sum += arr[i];
            if (map.containsKey(sum - target))
                minLen = Math.min(minLen, map.get(sum - target) - i);
            right[i] = minLen;
            map.put(sum, i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (left[i] < n && right[i + 1] < n)
                ans = Math.min(left[i] + right[i + 1], ans);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // sliding window
    public int minSumOfLengths2(int[] arr, int target) {
        int n = arr.length;
        int[] bestBefore = new int[n + 1];
        Arrays.fill(bestBefore, n + 1);
        int ans = n + 1;
        int i = 0;
        int sum = 0;
        int minLen = n + 1;
        for (int j = 0; j < n; j++) {
            sum += arr[j];
            while (i <= j && sum > target) {
                sum -= arr[i];
                i++;
            }
            if (sum == target) {
                ans = Math.min(ans, j - i + 1 + bestBefore[i]);
                minLen = Math.min(minLen, j - i + 1);
            }
            bestBefore[j + 1] = minLen;
        }
        return ans > n ? -1 : ans;
    }
}
