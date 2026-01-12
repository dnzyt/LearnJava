package easy;

// 2652. Sum Multiples

public class Solution2652 {
    public int sumOfMultiples(int n) {
        return sum(n, 3) + sum(n, 5) + sum(n, 7) -
                sum(n, 15) - sum(n, 35) - sum(n, 21) + sum(n, 105);
    }

    private int sum(int n, int m) {
        return (1 + (n / m)) * (n / m) / 2 * m;
    }
}
