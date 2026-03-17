package hard;

// 3869. Count Fancy Numbers in a Range

import java.util.HashMap;
import java.util.Map;

public class Solution3869 {
    private String high;
    private String low;

    private static int INIT = 0;
    private static int INC = 1;
    private static int DEC = 2;
    private static int NOT_GOOD = 3;

    private Map<Long, Long> memo;

    public long countFancy(long l, long r) {
        high = String.valueOf(r);
        low = String.valueOf(l - 1);
        memo = new HashMap<>();
        long a = dfs(0, true, 0, INIT, 0, high);
        memo.clear();
        long b = dfs(0, true, 0, INIT, 0, low);
        return a - b;
    }

    // 单端间接相减
    private long dfs(int i, boolean isLimited,
                     int prev, int state, int digitSum, String s) {
        int n = s.length();
        if (i == n) {
            if (state == INIT && prev != 0)
                return 1l;
            if (state == INC || state == DEC)
                return 1l;
            if (state == NOT_GOOD && isGood(digitSum))
                return 1l;
            return 0l;
        }

        long key = (long) digitSum << 32 | i << 20 | prev << 4 | state;
        if (!isLimited && memo.containsKey(key))
            return memo.get(key);


        int hi = isLimited ? s.charAt(i) - '0' : 9;
        long ans = 0;

        if (state == INIT && prev == 0) {
            ans += dfs(i + 1, false, prev, INIT, 0, s);
        }
        for (int d = 0; d <= hi; d++) {
            if (state == INIT) {
                if (prev == 0) {
                    if (d != 0)
                        ans += dfs(i + 1, isLimited && d == hi, d, INIT, digitSum + d, s);
                } else {
                    if (d - prev > 0)
                        ans += dfs(i + 1, isLimited && d == hi, d, INC, digitSum + d, s);
                    else if (d - prev < 0)
                        ans += dfs(i + 1, isLimited && d == hi, d, DEC, digitSum + d, s);
                    else
                        ans += dfs(i + 1, isLimited && d == hi, d, NOT_GOOD, digitSum + d, s);
                }
            } else if (state == INC) {
                if (d - prev > 0)
                    ans += dfs(i + 1, isLimited && d == hi, d, INC, digitSum + d, s);
                else
                    ans += dfs(i + 1, isLimited && d == hi, d, NOT_GOOD, digitSum + d, s);
            } else if (state == DEC) {
                if (d - prev < 0)
                    ans += dfs(i + 1, isLimited && d == hi, d, DEC, digitSum + d, s);
                else
                    ans += dfs(i + 1, isLimited && d == hi, d, NOT_GOOD, digitSum + d, s);
            } else if (state == NOT_GOOD) {
                ans += dfs(i + 1, isLimited && d == hi, d, NOT_GOOD, digitSum + d, s);
            }
        }
        if (!isLimited)
            memo.put(key, ans);
        return ans;
    }


    // 双端直接算
    private long dfs2(int i, boolean limitLo, boolean limitHi, int state, int prev, int digitSum) {
        int n = high.length();
        int diff = high.length() - low.length();
        if (i == n) {
            if (state == INIT && prev != 0)
                return 1l;
            if (state == INC || state == DEC)
                return 1l;
            if (state == NOT_GOOD && isGood(digitSum))
                return 1l;
            return 0;
        }

        long key = (long) digitSum << 32 | i << 20 | prev << 4 | state;
        if (!limitLo && !limitHi && memo.containsKey(key))
            return memo.get(key);
        int lo = limitLo ? (i >= diff ? low.charAt(i - diff) - '0' : 0) : 0;
        int hi = limitHi ? high.charAt(i) - '0' : 9;

        long ans = 0l;
        if (state == INIT && prev == 0 && i < diff)
            ans += dfs2(i + 1, true, false, INIT, 0, 0);
        for (int d = lo; d <= hi; d++) {
            if (state == INIT) {
                if (prev == 0) {
                    if (d > 0)
                        ans += dfs2(i + 1, limitLo && d == lo, limitHi && d == hi, INIT, d, digitSum + d);
                } else {
                    if (d - prev > 0)
                        ans += dfs2(i + 1, limitLo && d == lo, limitHi && d == hi, INC, d, digitSum + d);
                    else if (d - prev < 0)
                        ans += dfs2(i + 1, limitLo && d == lo, limitHi && d == hi, DEC, d, digitSum + d);
                    else
                        ans += dfs2(i + 1, limitLo && d == lo, limitHi && d == hi, NOT_GOOD, d, digitSum + d);
                }
            } else if (state == INC) {
                if (d - prev > 0)
                    ans += dfs2(i + 1, limitLo && d == lo, limitHi && d == hi, INC, d, digitSum + d);
                else
                    ans += dfs2(i + 1, limitLo && d == lo, limitHi && d == hi, NOT_GOOD, d, digitSum + d);
            } else if (state == DEC) {
                if (d - prev < 0)
                    ans += dfs2(i + 1, limitLo && d == lo, limitHi && d == hi, DEC, d, digitSum + d);
                else
                    ans += dfs2(i + 1, limitLo && d == lo, limitHi && d == hi, NOT_GOOD, d, digitSum + d);
            } else if (state == NOT_GOOD) {
                ans += dfs2(i + 1, limitLo && d == lo, limitHi && d == hi, NOT_GOOD, d, digitSum + d);
            }
        }

        if (!limitLo && !limitHi)
            memo.put(key, ans);
        return ans;
    }

    private boolean isGood(int num) {
        if (num < 100)
            return num / 10 != num % 10;
        return 1 < num / 10 % 10 && num / 10 % 10 < num % 10;
    }
}
