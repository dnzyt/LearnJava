package easy;

// 342. Power of Four

public class Solution342 {
    public boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;
        return (n & (n - 1)) == 0 && Integer.numberOfTrailingZeros(n) % 2 == 0;
    }
}
