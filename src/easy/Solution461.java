package easy;

// 461. Hamming Distance

public class Solution461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
