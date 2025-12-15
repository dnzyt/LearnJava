package medium;

// 3770. Largest Prime from Consecutive Prime Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution3770 {

    private static final int MX = 500000;
    private static final boolean[] np = new boolean[MX + 1];
    private static final List<Integer> specialNumbers = new ArrayList<>();

    static {
        Arrays.fill(np, true);
        for (int i = 2; i <= MX; i++) {
            if (np[i]) {
                for (long j = (long) i * i; j <= MX; j += i)
                    np[(int) j] = false;
            }
        }
        specialNumbers.add(0);
        int sum = 0;
        for (int i = 2; i <= MX; i++) {
            if (np[i]) {
                sum += i;
                if (sum > MX)
                    break;
                if (np[sum])
                    specialNumbers.add(sum);
            }
        }

    }

    public int largestPrime(int n) {
        int l = 0;
        int r = specialNumbers.size() - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (specialNumbers.get(mid) <= n)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return specialNumbers.get(l - 1);
    }

    public int largestPrime2(int n) {
        int idx = Collections.binarySearch(specialNumbers, n + 1);
        if (idx < 0)
            idx = ~idx;
        return specialNumbers.get(idx - 1);
    }
}
