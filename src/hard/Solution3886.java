package hard;

// 3886. Sum of Sortable Integers

public class Solution3886 {
    private int[] nextDec;
    private int[] nums;
    private int ans;

    public int sortableIntegers(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        nextDec = new int[n];
        int p = n;
        nextDec[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                p = i;
            nextDec[i] = p;
        }

        for (int k = 1; k * k <= n; k++) {
            if (n % k == 0) {
                solve(k);
                if (k * k < n)
                    solve((n / k));
            }
        }

        return ans;
    }

    private void solve(int k) {
        int n = nums.length;
        int lastMax = 0;
        for (int r = k - 1; r < n; r += k) {
            int l = r - k + 1;
            int m = nextDec[l];
            if (m >= r) {
                if (nums[l] < lastMax)
                    return;
                lastMax = nums[r];
            } else {
                if (nextDec[m + 1] < r || nums[m + 1] < lastMax || nums[l] < nums[r])
                    return;
                lastMax = nums[m];
            }

        }
        ans += k;
    }
}
