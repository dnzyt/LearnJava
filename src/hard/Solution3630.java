package hard;

// 3630. Partition Array for Maximum XOR and AND

import java.util.Arrays;

public class Solution3630 {

    // 普通消元
    class XorBasis {
        private int[] basis;

        public XorBasis(int n) {
            basis = new int[n];
        }

        public boolean insert(int num) {
            int n = basis.length;
            for (int i = n - 1; i >= 0; i--) {
                if (((num >> i) & 1) > 0) {
                    if (basis[i] == 0) {
                        basis[i] = num;
                        return true;
                    }
                    num ^= basis[i];
                }
            }
            return false;
        }

        public int maxXor() {
            int res = 0;
            for (int i = basis.length - 1; i >= 0; i--) {
                if ((res ^ basis[i]) > res)
                    res ^= basis[i];
            }
            return res;
        }

    }

    public long maximizeXorAndXor(int[] nums) {
        int n = nums.length;
        int mx = Arrays.stream(nums).max().getAsInt();
        int bits = 32 - Integer.numberOfLeadingZeros(mx);
        int[] subAnd = new int[1 << n];
        int[] subXor = new int[1 << n];
        // 刷表法 DP O(2^n)
        subAnd[0] = -1;
        for (int i = 0; i < n; i++) {
            int highBit = 1 << i;
            for (int mask = 0; mask < highBit; mask++) {
                subAnd[highBit | mask] = subAnd[mask] & nums[i];
                subXor[highBit | mask] = subXor[mask] ^ nums[i];
            }
        }
        subAnd[0] = 0;
        long res = 0l;
        for (int subMask = 0; subMask < (1 << n); subMask++) {
            long curr = subAnd[subMask];
            curr += maxXor(((1 << n) - 1) ^ subMask, subXor, bits, nums);
            if (res < curr)
                res = curr;
        }
        return res;
    }

    private long maxXor(int subMask, int[] subXor, int bits, int[] nums) {
        int currXor = subXor[subMask];
        XorBasis b = new XorBasis(bits);
        for (int i = 0; i < nums.length; i++) {
            if (((subMask >> i) & 1) > 0) {
                b.insert(nums[i] & (~currXor));
            }
        }
        return (long) currXor + 2 * b.maxXor();
    }
}
