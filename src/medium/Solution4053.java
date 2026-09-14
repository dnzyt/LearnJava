package medium;

// 4053. Minimum Operations to Make Every Element Palindromic

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4053 {

    private static final int MX = 2_000_000_002;
    private static List<Integer>[] pals = new ArrayList[2];
    private static boolean initialized = false;

    public Solution4053() {
        if (initialized)
            return;
        initialized = true;
        Arrays.setAll(pals, i -> new ArrayList<>());
        pals[0].add(0);
        pals[1].add(0);

        for (int base = 1; ; base *= 10) {
            for (int i = base; i < base * 10; i++) {
                int x = i;
                for (int t = i / 10; t > 0; t /= 10)
                    x = x * 10 + t % 10;
                if (x > MX)
                    return;
                pals[x % 2].add(x);
            }
            for (int i = base; i < base * 10; i++) {
                int x = i;
                for (int t = i; t > 0; t /= 10)
                    x = x * 10 + t % 10;
                if (x > MX)
                    return;
                pals[x % 2].add(x);
            }
        }
    }

    public long minOperations(int[] nums) {
        long ans = 0;
        for (int num : nums) {
            int p = lowerBound(pals[num % 2], num);
            ans += Math.min(pals[num % 2].get(p) - num, num - pals[num % 2].get(p - 1));
        }
        return ans / 2;
    }

    private int lowerBound(List<Integer> nums, int target) {
        int l = 0, r = nums.size() - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int x = nums.get(mid);
            if (x >= target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}
