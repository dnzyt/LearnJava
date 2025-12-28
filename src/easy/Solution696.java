package easy;

// 696. Count Binary Substrings

public class Solution696 {
    public int countBinarySubstrings(String s) {
        char[] c = s.toCharArray();
        int cnt0 = 0, cnt1 = 0, ans = 0;
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j + 1 < s.length() && c[j] == c[j + 1])
                j++;
            if (c[i] == '0')
                cnt0 = j - i + 1;
            else
                cnt1 = j - i + 1;
            ans += Math.min(cnt0, cnt1);
            i = j + 1;
        }
        return ans;
    }
}
