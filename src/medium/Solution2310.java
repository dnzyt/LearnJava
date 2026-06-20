package medium;

// 2310. Sum of Numbers With Units Digit K

public class Solution2310 {
    public int minimumNumbers(int num, int k) {
        if (num == 0)
            return 0;
        for (int i = 1; i <= 10 && num - i * k >= 0; i++) {
            if (k * i % 10 == num % 10)
                return i;
        }
        return -1;
    }
}
