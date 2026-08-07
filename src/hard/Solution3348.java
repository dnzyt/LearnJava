package hard;

// 3348. Smallest Divisible Digit Product II

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3348 {
    public String smallestNumber(String num, long t) {
        int cnt = 0;
        long tmp = t;
        for (int x : List.of(2, 3, 5, 7)) {
            while (tmp % x == 0) {
                cnt++;
                tmp /= x;
            }
        }
        if (tmp != 1)
            return "-1";

        cnt = Math.max(cnt - num.length(), 1);
        num = "0".repeat(cnt) + num;
        char[] ans = new char[num.length()];
        Arrays.fill(ans, '0');
        Set<Long>[] visited = new Set[num.length()];
        Arrays.setAll(visited, i -> new HashSet<>());

        dfs(0, t, true, num, cnt, ans, visited);
        for (int i = 0; i < ans.length; i++)
            if (ans[i] != '0')
                return new String(ans, i, ans.length - i);
        return null;
    }

    private boolean dfs(int i, long t, boolean limited, String num, int cnt, char[] ans, Set<Long>[] visited) {
        if (i == num.length())
            return t == 1L;
        if (!limited && !visited[i].add(t))
            return false;
        int low = 0;
        int x = num.charAt(i) - '0';

        if (limited)
            low = (x > 0 || i < cnt) ? x : 1;
        else
            low = 1;
        for (int d = low; d < 10; d++) {
            ans[i] = (char) ('0' + d);
            long newT = d > 1 ? t / gcd(d, t) : t;
            if (dfs(i + 1, newT, limited && d == x, num, cnt, ans, visited))
                return true;
        }
        return false;
    }

    private long gcd(long a, long b) {
        while (a != 0) {
            long t = a;
            a = b % a;
            b = t;
        }
        return b;
    }
}
