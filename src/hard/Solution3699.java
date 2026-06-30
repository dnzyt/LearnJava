package hard;

// 3699. Number of ZigZag Arrays I

import java.util.Arrays;

public class Solution3699 {
    private static final int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        // 0: up, 1: down
        r = r - l + 1;
        long[] f0 = new long[r];
        long[] f1 = new long[r];
        Arrays.fill(f0, 1);
        Arrays.fill(f1, 1);
        for (int i = 1; i < n; i++) {
            long pre = 0, suf = 0;

            for (int j = 0; j < r; j++) {
                long v = f1[j];
                f1[j] = pre;
                pre = (pre + v) % MOD;
            }
            for (int j = r - 1; j >= 0; j--) {
                long v = f0[j];
                f0[j] = suf;
                suf = (suf + v) % MOD;
            }
            long[] temp = f0;
            f0 = f1;
            f1 = temp;
        }
        long sum = 0;
        for (int i = 0; i < r; i++)
            sum = (sum + f0[i] + f1[i]) % MOD;
        return (int) sum;
    }

    public int zigZagArrays2(int n, int l, int r) {
        // 0: up, 1: down
        // 进一步优化，只考虑刚开始上升的情况，最后结果 ✖ 2就行
        r = r - l + 1;
        long[] f = new long[r];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            long pre = 0, suf = 0;
            if (i % 2 == 0) {
                for (int j = 0; j < r; j++) {
                    long v = f[j];
                    f[j] = pre;
                    pre = (pre + v) % MOD;
                }
            } else {
                for (int j = r - 1; j >= 0; j--) {
                    long v = f[j];
                    f[j] = suf;
                    suf = (suf + v) % MOD;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < r; i++)
            sum = (sum + f[i]) % MOD;
        return (int) (sum * 2 % MOD);
    }

    // 再进一步优化
    public int zigZagArrays3(int n, int l, int r) {
        r = r - l + 1;
        long[] f = new long[r];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            long[] np = new long[r];
            long presum = 0;
            for (int j = 0; j < r; j++) {
                np[r - 1 - j] = presum;
                presum = (presum + f[j]) % MOD;
            }
            f = np;
        }
        long sum = 0;
        for (long num : f)
            sum = (sum + num) % MOD;
        return (int) (sum * 2 % MOD);
    }
}
