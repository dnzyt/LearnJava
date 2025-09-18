package medium;

import util.GCD;

public class Solution2513 {
    private long dv1;
    private long dv2;
    private long cnt1;
    private long cnt2;

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        this.dv1 = divisor1;
        this.dv2 = divisor2;
        this.cnt1 = uniqueCnt1;
        this.cnt2 = uniqueCnt2;

        long left = 1;
        long right = 2 * (cnt1 + cnt2) + 1;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (isValid(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;

    }

    private boolean isValid(long num) {
        long lcm = GCD.lcm(dv1, dv2);
        long left1 = Math.max(cnt1 - (num / dv2 - num / lcm), 0);
        long left2 = Math.max(cnt2 - (num / dv1 - num / lcm), 0);
        long common = num - (num / dv1 + num / dv2 - num / lcm);

        return common >= left1 + left2;

    }
}
