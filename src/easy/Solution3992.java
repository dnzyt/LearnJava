package easy;

// 3992. Rearrange String to Avoid Character Pair

public class Solution3992 {
    public String rearrangeString(String s, char x, char y) {
        char[] chs = s.toCharArray();
        int n = s.length();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < n && chs[i] != x)
                i++;
            while (j >= 0 && chs[j] != y)
                j--;
            if (i > j)
                break;
            chs[i] = y;
            chs[j] = x;
            i++;
            j--;
        }
        return new String(chs);
    }
}
