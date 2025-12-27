package easy;

// 434. Number of Segments in a String

public class Solution434 {
    public int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0)
            return 0;
        int ans = 1;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                ans++;
                while (i + 1 < s.length() && s.charAt(i + 1) == ' ')
                    i++;
            }
            i++;
        }
        return ans;
    }
}
