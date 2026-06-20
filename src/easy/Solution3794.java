package easy;

// 3794. Reverse String Prefix

public class Solution3794 {
    public String reversePrefix(String s, int k) {
        StringBuilder sb = new StringBuilder(s.substring(0, k)).reverse();
        sb.append(s.substring(k));
        return sb.toString();
    }
}
