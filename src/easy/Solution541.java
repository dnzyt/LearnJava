package easy;

// 541. Reverse String II

public class Solution541 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            StringBuilder t = new StringBuilder(s.substring(i, Math.min(i + k, s.length())));
            t.reverse();
            sb.append(t);
            i += k;
            if (i >= s.length())
                break;
            t = new StringBuilder(s.substring(i, Math.min(i + k, s.length())));
            sb.append(t);
            i += k;
        }
        return sb.toString();
    }
}
