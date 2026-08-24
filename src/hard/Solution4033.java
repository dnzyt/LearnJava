package hard;

// 4033. Valid K-Unique Subarrays I

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution4033 {
    private static final Random random = new Random();
    /*
    * 一堆数如果每个数字出现的次数是偶数次，那么异或和为0
    * 但是反过来不一定成立，如果一堆数的异或和为0，那么不能说明每个数的出现次数是偶数次
    * 但是可以通过异或哈希来近似得到以上的结论，虽然不能百分之百准确，但是出错的概率非常小
    * 过程是把数字映射成64位整数，如果映射之后的数的异或和为0，那么几乎就可以说明这些数的出现次数是偶数次
    *
    *
    * 题目还要保证不同的数的种类恰好为k次
    * 恰好型的问题往往转换成>k次和>=k次(<k次和<=k次)的问题
    * 枚举右，维护左，左边维护的两个位置分别是<k次的最左端和<=k次的最左端
    * */
    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        Map<Integer, Long> map = new HashMap<>();
        long[] presum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], random.nextLong());
            presum[i + 1] = presum[i] ^ map.get(nums[i]);
        }
        boolean[] ans = new boolean[queries.length];
        int[] f = calc(nums, k + 1);
        int[] s = calc(nums, k);
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = presum[r + 1] == presum[l] && f[r] <= l && l < s[r];
        }
        return ans;
    }

    // 左边第一个小于k种数字的位置
    private int[] calc(int[] nums, int k) {
        int l = 0;
        int[] left = new int[nums.length];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
            while (cnt.size() >= k) {
                cnt.merge(nums[l], -1, Integer::sum);
                if (cnt.get(nums[l]) == 0)
                    cnt.remove(nums[l]);
                l++;
            }
            left[i] = l;
        }
        return left;
    }
}
