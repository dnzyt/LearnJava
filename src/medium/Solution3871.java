package medium;

// 3871. Count Commas in Range II

public class Solution3871 {
    public long countCommas(long n) {
        long low = 1000;
        long ans = 0;
        while (low <= n) {
            ans += n - low + 1;
            low *= 1000;
        }
        return ans;
    }
}
