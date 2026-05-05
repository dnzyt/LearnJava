package easy;

// 2566. Maximum Difference by Remapping a Digit

public class Solution2566 {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int mx = num;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                mx = Integer.parseInt(s.replace(c, '9'));
                break;
            }
        }
        int mn = Integer.parseInt(s.replace(s.charAt(0), '0'));
        return mx - mn;
    }
}
