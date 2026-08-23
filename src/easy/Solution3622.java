package easy;

// 3622. Check Divisibility by Digit Sum and Product

public class Solution3622 {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int x = n;
        while (x > 0) {
            int d = x % 10;
            x /= 10;
            sum += d;
            product *= d;
        }
        return n % (sum + product) == 0;
    }
}
