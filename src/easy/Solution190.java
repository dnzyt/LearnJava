package easy;

// 190. Reverse Bits

public class Solution190 {
    private static final int M1 = 0x55555555;
    private static final int M2 = 0x33333333;
    private static final int M3 = 0x0f0f0f0f;
    private static final int M4 = 0X00ff00ff;

    public int reverseBits(int n) {
        n = (n >>> 1) & M1 | (n & M1) << 1;
        n = (n >>> 2) & M2 | (n & M2) << 2;
        n = (n >>> 4) & M3 | (n & M3) << 4;
        n = (n >>> 8) & M4 | (n & M4) << 8;
        return n >>> 16 | n << 16;
    }
}
