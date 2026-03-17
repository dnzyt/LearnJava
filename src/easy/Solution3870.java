package easy;

// 3870. Count Commas in Range

public class Solution3870 {
    public int countCommas(int n) {
        int ans = 0;
        int commaCnt = 0;
        int base = 1000;
        while (n > base - 1) {
            ans += 999 * commaCnt;
            commaCnt++;
            base *= 1000;
        }
        base /= 1000;
        ans += (n - (base - 1)) * commaCnt;
        return ans;
    }

    // 横看成岭侧成峰
    public int countCommas2(int n) {
        int low = 1000;
        int ans = 0;
        while (low <= n) {
            ans += n - low + 1;
            low *= 1000;
        }
        return ans;
    }

}
