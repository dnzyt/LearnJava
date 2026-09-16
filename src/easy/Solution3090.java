package easy;

// 3090. Maximum Length Substring With Two Occurrences

public class Solution3090 {
    public int maximumLengthSubstring(String s) {
        char[] chs = s.toCharArray();
        int j = 0;
        int[] cnt = new int[26];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = chs[i] - 'a';
            cnt[x]++;
            while (cnt[x] > 2) {
                cnt[chs[j] - 'a']--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
