package medium;

// 3513. Number of Unique XOR Triplets I

public class Solution3513 {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        return n <= 2 ? n : 1 << (32 - Integer.numberOfLeadingZeros(n));
    }
}
