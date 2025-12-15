package medium;

// 3776. Minimum Moves to Balance Circular Array

import java.util.Arrays;

public class Solution3776 {
    public long minMoves(int[] balance) {
        int n = balance.length;
        long sum = 0;


        int idx = -1;
        for (int i = 0; i < n; i++) {
            sum += balance[i];
            if (balance[i] < 0) {
                idx = i;
            }
        }
        if (sum < 0)
            return -1;
        if (idx < 0)
            return 0;

        int need = -balance[idx];
        long ans = 0;
        for (int i = 1; ; i++) {
            int cost = balance[(idx - i + n) % n] + balance[(idx + i) % n];
            if (cost >= need) {
                ans += (long) need * i;
                return ans;
            }
            need -= cost;
            ans += (long) cost * i;
        }
    }
}
