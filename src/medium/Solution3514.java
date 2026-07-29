package medium;

// 3514. Number of Unique XOR Triplets II

import java.util.HashSet;
import java.util.Set;

public class Solution3514 {
    public int uniqueXorTriplets(int[] nums) {
        int mx = 0;
        for (int num : nums)
            mx = Math.max(mx, num);
        int n = 32 - Integer.numberOfLeadingZeros(mx);
        boolean[] has = new boolean[1 << n];
        for (int x : nums)
            for (int y : nums)
                has[x ^ y] = true;
        boolean[] ans = new boolean[1 << n];
        for (int xy = 0; xy < (1 << n); xy++) {
            if (!has[xy])
                continue;
            for (int z : nums)
                ans[xy ^ z] = true;
        }
        int cnt = 0;
        for (boolean a : ans)
            if (a)
                cnt++;
        return cnt;
    }
}
