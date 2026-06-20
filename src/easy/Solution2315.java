package easy;

// 2315. Count Asterisks

public class Solution2315 {
    public int countAsterisks(String s) {
        char[] chs = s.toCharArray();
        int n = s.length();
        int ans = 0;
        int i = 0;
        while (i < n) {
            int first = i;
            while (first < n) {
                if (chs[first] == '|')
                    break;
                if (chs[first] == '*')
                    ans++;
                first++;
            }
            if (first == n)
                break;
            int second = first + 1;
            while (second < n) {
                if (chs[second] == '|')
                    break;
                second++;
            }
            i = second + 1;
        }

        return ans;
    }
}
