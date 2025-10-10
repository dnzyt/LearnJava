package easy;

// 2595. Number of Even and Odd Bits

public class Solution2595 {
    public int[] evenOddBit(int n) {
        int e = 0b0101010101010101;
        int even = Integer.bitCount(n & e);
        int odd = Integer.bitCount(n & ~e);
        return new int[]{even, odd};
    }
}
