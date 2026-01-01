package easy;

// 925. Long Pressed Name

public class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int m = typed.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            int cnt1 = 1;
            while (i + 1 < n && name.charAt(i) == name.charAt(i + 1)) {
                cnt1++;
                i++;
            }
            if (name.charAt(i) != typed.charAt(j))
                return false;

            int cnt2 = 1;
            while (j + 1 < m && typed.charAt(j) == typed.charAt(j + 1)) {
                cnt2++;
                j++;
            }
            if (cnt1 > cnt2)
                return false;
            i++;
            j++;
        }
        return i == n && j == m;
    }
}
