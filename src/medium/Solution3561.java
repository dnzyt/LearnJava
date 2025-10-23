package medium;

// 3561. Resulting String After Adjacent Removals

public class Solution3561 {
    public String resultingString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.isEmpty())
                sb.append(c);
            else {
                int last = sb.charAt(sb.length() - 1) - 'a';
                if ((last + 1) % 26 == c - 'a' || (last - 1 + 26) % 26 == c - 'a')
                    sb.deleteCharAt(sb.length() - 1);
                else
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
