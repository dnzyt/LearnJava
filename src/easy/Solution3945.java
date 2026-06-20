package easy;

// 3945. Digit Frequency Score

public class Solution3945 {

    public int digitFrequencyScore(int n) {
        int ans = 0;
        while (n > 0) {
            ans += (n % 10);
            n /= 10;
        }
        return ans;
    }
}
