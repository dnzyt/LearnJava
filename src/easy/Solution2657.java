package easy;

// 2657. Find the Prefix Common Array of Two Arrays

public class Solution2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        long a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            a |= (1L << A[i]);
            b |= (1L << B[i]);
            ans[i] = Long.bitCount(a & b);
        }
        return ans;
    }
}
