package medium;

// 3720. Lexicographically Smallest Permutation Greater Than Target

public class Solution3720 {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
            cnt[target.charAt(i) - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        next:
        for (int i = n - 1; i >= 0; i--) {
            char curr = target.charAt(i);
            cnt[curr - 'a']++;
            for (int k = 0; k < 26; k++)
                if (cnt[k] < 0)
                    continue next;
            for (int j = curr - 'a' + 1; j < 26; j++) {
                if (cnt[j] == 0)
                    continue;
                sb.append((char) ('a' + j));
                cnt[j]--;
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0)
                        sb.append(String.valueOf((char) ('a' + k)).repeat(cnt[k]));
                }
                return target.substring(0, i) + sb.toString();
            }
        }
        return "";
    }

}
