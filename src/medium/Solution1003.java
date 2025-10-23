package medium;

// 1003. Check If Word Is Valid After Substitutions

public class Solution1003 {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() < 2)
                sb.append(c);
            else {
                int a = sb.charAt(sb.length() - 2), b = sb.charAt(sb.length() - 1);
                if (a == 'a' && b == 'b' && c == 'c')
                    sb.delete(sb.length() - 2, sb.length());
                else
                    sb.append(c);
            }
        }

        return sb.isEmpty();
    }
}
