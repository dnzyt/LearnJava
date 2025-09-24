package easy;

// 2748. Number of Beautiful Pairs

public class Solution2748 {
    public int countBeautifulPairs(int[] nums) {
        int[] d = new int[10];
        int ans = 0;
        for (int num : nums) {
            for (int i = 1; i < 10; i++) {
                if (d[i] != 0 && gcd(i, num % 10) == 1)
                    ans += d[i];
            }
            while (num >= 10)
                num /= 10;
            d[num]++;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
