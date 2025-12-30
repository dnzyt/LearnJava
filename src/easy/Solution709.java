package easy;

// 709. To Lower Case

public class Solution709 {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 65 && c <= 90)
                c |= 32;
            sb.append(c);
        }
        return sb.toString();
    }
}
