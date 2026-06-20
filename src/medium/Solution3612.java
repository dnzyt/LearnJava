package medium;

// 3612. Process String with Special Operations I

public class Solution3612 {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (char c : chs) {
            if (c == '*') {
                if (sb.length() > 0)
                    sb.deleteCharAt(sb.length() - 1);
            } else if (c == '#') {
                sb.append(sb);
            } else if (c == '%') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
