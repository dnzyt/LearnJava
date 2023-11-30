package medium;

public class Solution5 {

    // Manacher - O(n)
    public String longestPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        sb.append('#');
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }

        String ss = sb.toString();
        int n = ss.length();
        int maxRight = -1;
        int maxCenter = -1;
        int[] p = new int[n];

        int maxRadius = 0;
        int center = 0;

        for (int i = 0; i < n; i++) {
            int r = 0;
            if (maxRight > i) {
                int j = 2 * maxCenter - i;
                r = Math.min(p[j], maxRight - i);
                while (i - r >= 0 && i + r < n && ss.charAt(i - r) == ss.charAt(i + r))
                    r ++;
            } else {
                while (i - r >= 0 && i + r < n && ss.charAt(i - r) == ss.charAt(i + r))
                    r ++;
            }

            p[i] = r - 1;

            if (maxRight < i + p[i]) {
                maxRight = i + p[i];
                maxCenter = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (maxRadius < p[i]) {
                maxRadius = p[i];
                center = i;
            }
        }

        int start = (center - maxRadius) / 2;
        int length = (2 * maxRadius + 1) / 2;
        return s.substring(start, start + length);

    }

}
