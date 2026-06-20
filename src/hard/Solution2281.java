package hard;

// 2281. Sum of Total Strength of Wizards

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2281 {
    private static final int MOD = 1000000007;

    public int totalStrength(int[] strength) {
        int n = strength.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            int curr = strength[i];
            while (!st.isEmpty() && strength[st.peek()] >= curr) {
                right[st.pop()] = i;
            }
            if (!st.isEmpty())
                left[i] = st.peek();
            st.push(i);
        }
        long s = 0l;
        // 前缀和的前缀和
        long[] ppsum = new long[n + 2];
        for (int i = 1; i < n + 1; i++) {
            s += strength[i - 1];
            ppsum[i + 1] = (ppsum[i] + s) % MOD;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int L = left[i] + 1, R = right[i] - 1;
            long tot = ((i - L + 1) * (ppsum[R + 2] - ppsum[i + 1]) - (R - i + 1) * (ppsum[i + 1] - ppsum[L])) % MOD;
            ans = (ans + tot * strength[i] % MOD) % MOD;
        }
        return (int) (ans + MOD) % MOD;
    }
}
