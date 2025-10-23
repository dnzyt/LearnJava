package easy;

// 1544. Make The String Great

public class Solution1544 {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.isEmpty())
                sb.append(c);
            else {
                char last = sb.charAt(sb.length() - 1);
                if (last + 32 == c || last - 32 == c)
                    sb.deleteCharAt(sb.length() - 1);
                else
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
