package hard;

// 956. Tallest Billboard

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution956 {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int sum = 0;
        for (int r : rods)
            sum += r;

        int[] f = new int[sum + 1];
        Arrays.fill(f, -1);
        f[0] = 0;
        for (int num : rods) {
            int[] c = new int[f.length];
            System.arraycopy(f, 0, c, 0, c.length);
            for (int j = 0; j <= sum; j++) {
                if (c[j] < 0)
                    continue;
                f[j + num] = Math.max(f[j + num], c[j]);
                f[Math.abs(j - num)] = Math.max(c[j] + Math.min(j, num), f[Math.abs(j - num)]);
            }
        }
        return f[0];
    }
}
