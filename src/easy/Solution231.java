package easy;

// 231. Power of Two

public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n >= 0)
            return Integer.bitCount(n) == 1;
        return false;
    }
}
