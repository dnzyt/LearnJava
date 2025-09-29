package medium;

// 2559. Count Vowel Strings in Ranges

public class Solution2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + (isValid(words[i]) ? 1 : 0);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = s[right + 1] - s[left];
        }
        return ans;
    }

    private boolean isValid(String s) {
        char f = s.charAt(0);
        char l = s.charAt(s.length() - 1);
        return (f == 'a' || f == 'e' || f == 'i' || f == 'o' || f == 'u')
                && (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u');
    }
}
