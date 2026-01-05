package easy;

// 3798. Largest Even Number

public class Solution3798 {
    public String largestEven(String s) {
        int i = s.length();
        while (i > 0 && s.charAt(i - 1) == '1') {
            i--;
        }
        return s.substring(0, i);
    }
}
