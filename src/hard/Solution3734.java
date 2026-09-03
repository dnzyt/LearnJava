package hard;

// 3734. Lexicographically Smallest Palindromic Permutation Greater Than Target

public class Solution3734 {
    public String lexPalindromicPermutation(String s, String target) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray())
            cnt[c - 'a']++;
        String midCh = "";
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] % 2 == 0)
                continue;
            if (!midCh.isEmpty())
                return "";
            midCh = "" + (char) ('a' + i);
            cnt[i]--;
        }
        for (int i = 0; i < target.length() / 2; i++)
            cnt[target.charAt(i) - 'a'] -= 2;

        if (isValid(cnt)) {
            String left = target.substring(0, target.length() / 2);
            String whole = left + midCh + new StringBuilder(left).reverse();
            if (target.compareTo(whole) < 0)
                return whole;
        }

        for (int i = target.length() / 2 - 1; i >= 0; i--) {
            char c = target.charAt(i);
            cnt[c - 'a'] += 2;
            if (!isValid(cnt))
                continue;

            for (int j = c - 'a' + 1; j < 26; j++) {
                if (cnt[j] == 0)
                    continue;
                cnt[j] -= 2;
                StringBuilder sb = new StringBuilder(target.substring(0, i));
                sb.append((char) (j + 'a'));

                for (int k = 0; k < 26; k++) {
                    while (cnt[k] > 0) {
                        sb.append((char) (k + 'a'));
                        cnt[k] -= 2;
                    }
                }
                String left = sb.toString();
                return left + midCh + sb.reverse().toString();
            }
        }

        return "";
    }

    private boolean isValid(int[] cnt) {
        for (int j : cnt)
            if (j < 0)
                return false;
        return true;
    }
}
