package easy;

// 953. Verifying an Alien Dictionary

import java.util.Arrays;

public class Solution953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ord = new int[26];
        for (int i = 0; i < 26; i++)
            ord[order.charAt(i) - 'a'] = i;
        String[] clone = words.clone();
        Arrays.sort(clone, (a, b) -> {
            int m = a.length(), n = b.length();
            int i = 0, j = 0;
            while (i < m && j < n) {
                if (a.charAt(i) != b.charAt(j))
                    return ord[a.charAt(i) - 'a'] - ord[b.charAt(j) - 'a'];
                i++;
                j++;
            }
            if (i < m)
                return 1;
            if (j < n)
                return -1;
            return 0;
        });
        for (int i = 0; i < words.length; i++)
            if (!words[i].equals(clone[i]))
                return false;
        return true;
    }
}
