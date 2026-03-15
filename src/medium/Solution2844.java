package medium;

// 2844. Minimum Operations to Make a Special Number

public class Solution2844 {
    public int minimumOperations(String num) {
        int n = num.length();
        int a = contains(num, '0', '0') ? dfs(num, "00") : n;
        int b = contains(num, '2', '5') ? dfs(num, "25") : n;
        int c = contains(num, '5', '0') ? dfs(num, "50") : n;
        int d = contains(num, '7', '5') ? dfs(num, "75") : n;
        int mn = Math.min(Math.min(a, b), Math.min(c, d));
        return mn;
    }

    private int dfs(String a, String b) {
        if (a.isEmpty() || b.isEmpty())
            return 0;
        int n = a.length(), m = b.length();
        if (a.charAt(n - 1) == b.charAt(m - 1))
            return dfs(a.substring(0, n - 1), b.substring(0, m - 1));
        return dfs(a.substring(0, n - 1), b) + 1;
    }

    private boolean contains(String num, char a, char b) {
        char[] chs = num.toCharArray();
        int n = num.length();
        int i = 0;
        for (; i < n; i++) {
            if (chs[i] == a)
                break;
        }
        if (i == n) return false;
        for (; i < n; i++) {
            if (chs[i] == b)
                break;
        }
        if (i == n) return false;
        return true;
    }
}
