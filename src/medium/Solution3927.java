package medium;

// 3927. Minimize Array Sum Using Divisible Replacements

import java.util.*;

public class Solution3927 {
    private static int MAXN = 100001;
    private static boolean initialized = false;
    private static List<Integer>[] divisors;

    public Solution3927() {
        if (initialized)
            return;
        initialized = true;
        divisors = new List[MAXN];
        Arrays.setAll(divisors, i -> new ArrayList<>());
        for (int i = 1; i < MAXN; i++) {
            for (int j = i; j < MAXN; j += i)
                divisors[j].add(i);
        }
    }


    public long minArraySum(int[] nums) {
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.merge(num, 1, Integer::sum);
        for (int k : map.keySet()) {
            int c = map.get(k);
            for (int d : divisors[k]) {
                if (map.containsKey(d)) {
                    ans += d * c;
                    break;
                }
            }
        }
        return ans;
    }
}
