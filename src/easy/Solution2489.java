package easy;

// 2894. Divisible and Non-divisible Sums Difference

public class Solution2489 {
    public int differenceOfSums(int n, int m) {
        return (1 + n) * n / 2 - (n / m) * (n / m + 1) * m;
    }
}
