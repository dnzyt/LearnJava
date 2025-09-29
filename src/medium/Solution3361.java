package medium;

// 3361. Shift Distance Between Two Strings

public class Solution3361 {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        int MOD = 26;
        long[] nxtSum = new long[MOD * 2 + 1];
        long[] preSum = new long[MOD * 2 + 1];

        for (int i = 0; i < MOD * 2; i++) {
            nxtSum[i + 1] = nxtSum[i] + nextCost[i % MOD];
            preSum[i + 1] = preSum[i] + previousCost[i % MOD];
        }

        long ans = 0;
        ;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            int b = t.charAt(i) - 'a';
            if (a == b) continue;
            ans += (Math.min(a < b ? nxtSum[b] - nxtSum[a] : nxtSum[b + MOD] - nxtSum[a],
                    a > b ? preSum[a + 1] - preSum[b + 1] : preSum[a + MOD + 1] - preSum[b + 1]));
        }
        return ans;
    }
}
