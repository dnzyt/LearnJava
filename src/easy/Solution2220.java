package easy;

// 2220. Minimum Bit Flips to Convert Number

public class Solution2220 {
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount((start ^ goal));
    }
}
