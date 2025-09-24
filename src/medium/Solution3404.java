package medium;

// 3404. Count Special Subsequences

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Solution3404 {
    public long numberOfSubsequences(int[] nums) {
        long ans = 0;
        int n = nums.length;
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        for (int i = 4; i < n; i++) {
            // b
            int b = nums[i - 2];
            for (int j = i - 4; j >= 0; j--) {
                int a = nums[j];
                int g = gcd(a, b);
                Pair<Integer, Integer> pair = new Pair<>(a / g, b / g);
                int cnt = map.getOrDefault(pair, 0);
                map.put(pair, cnt + 1);
            }
            int c = nums[i];
            for (int j = i + 2; j < n; j++) {
                int d = nums[j];
                int g = gcd(c, d);
                Pair<Integer, Integer> pair = new Pair<>(d / g, c / g);
                int cnt = map.getOrDefault(pair, 0);
                ans += cnt;
            }
        }


        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
