package easy;

// 507. Perfect Number

public class Solution507 {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += (i == num ? 0 : i);
                sum += (num / i == num ? 0 : num / i);
            }
        }
        return sum == num;
    }
}
