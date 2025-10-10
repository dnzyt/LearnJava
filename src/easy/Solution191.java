package easy;

// 191. Number of 1 Bits

public class Solution191 {
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = n; i != 0; i -= lowbit(i)) ans++;
        return ans;
    }

    private int lowbit(int x) {
        return x & -x;
    }
}
