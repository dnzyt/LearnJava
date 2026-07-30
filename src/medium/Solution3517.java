package medium;

// 3517. Smallest Palindromic Rearrangement I

import java.util.Arrays;

public class Solution3517 {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int m = s.length() / 2;
        char[] first = s.substring(0, m).toCharArray();
        Arrays.sort(first);
        StringBuilder sb = new StringBuilder(n);
        sb.append(first);
        if (n % 2 > 0)
            sb.append(s.charAt(m));
        for (int i = m - 1; i >= 0; i--)
            sb.append(first[i]);
        return sb.toString();
    }
}
