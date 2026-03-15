package hard;

// 2835. Minimum Operations to Form Subsequence With Target Sum

/*
统计每一个bit上有多少个1
当前位上的1如果够用，那么剩下的可以向后面的bit进位
如果当前位上的1不够用，那么去寻找后面最近的1来借位

 * 1 - 00000001
 * 2 - 00000010
 * 8 - 00001000
 *
 * 7 - 00000111
 *
 *
 * */


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2835 {

    public int minOperations(List<Integer> nums, int target) {
        int[] counter = new int[33];
        for (Integer num : nums) {
            int idx = 0;
            int digit = 1;
            while (num != digit) {
                digit <<= 1;
                idx++;
            }
            counter[idx]++;
        }

        int i = 0;
        int res = 0;
        while (i < 32) {
            if (((target >> i) & 1) == 1) {
                if (counter[i] >= 1) {
                    counter[i + 1] += (counter[i] - 1) / 2;
                    i++;
                    continue;
                } else {
                    int j = i + 1;
                    while (j < 32) {
                        if (counter[j] > 0) {
                            counter[j]--;
                            res += (j - i);
                            i = j;
                            break;
                        }
                        j++;
                    }
                    if (j == 32) return -1;
                }
            } else {
                counter[i + 1] += counter[i] / 2;
                i++;
            }
        }


        return res;
    }

    // 贪心
    public int minOperations2(List<Integer> nums, int target) {
        long sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            sum += num;
            cnt.merge(num, 1, Integer::sum);
        }
        if (sum < target)
            return -1;

        long s = 0;
        int i = 0, ans = 0;
        while ((1l << i) <= target) {
            s += (long) cnt.getOrDefault(1 << i, 0) << i;
            long mask = (1l << (i + 1)) - 1;
            if (s >= (target & mask)) {
                i++;
                continue;
            }
            ans++;
            i++;
            while (cnt.getOrDefault(1 << i, 0) == 0) {
                i++;
                ans++;
            }
        }
        return ans;
    }
}



