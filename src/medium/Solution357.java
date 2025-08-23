package medium;

// 357. Count Numbers with Unique Digits

public class Solution357 {

    public int countNumbersWithUniqueDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++)
            res += A(10, i) - A(9, i - 1);
        return res;
    }

    private int A(int n, int m) {
        int res = 1;
        for (int i = n; i > n - m; i--)
            res *= i;
        return res;
    }
}
