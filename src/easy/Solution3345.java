package easy;

// 3345. Smallest Divisible Digit Product I

public class Solution3345 {
    public int smallestNumber(int n, int t) {
        for (int i = n; ; i++) {
            int prod = 1;
            int x = i;
            while (x > 0) {
                prod *= x % 10;
                x /= 10;
            }
            if (prod % t == 0)
                return i;
        }
    }
}
