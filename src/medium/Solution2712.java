package medium;

// 2712. Minimum Cost to Make All Characters Equal

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class Solution2712 {
    public long minimumCost(String s) {
        char[] ss = s.toCharArray();
        int n = s.length();
        long[] leftDP = new long[n];
        long[] rightDP = new long[n];

        for (int i = 1; i < n; i++) {
            leftDP[i] = leftDP[i - 1] + (ss[i] == ss[i - 1] ? 0 : i);
            rightDP[n - 1 - i] = rightDP[n - i] + (ss[n - 1 - i] == ss[n - i] ? 0 : i);
        }

        AtomicLong res = new AtomicLong(Long.MAX_VALUE);
        IntStream.range(0, n).forEach(i -> res.set(Math.min(res.get(), leftDP[i] + rightDP[i])));
        return res.get();
    }
}
