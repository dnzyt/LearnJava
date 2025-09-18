package easy;

// 2839. Check if Strings Can be Made Equal With Operations I

import java.util.Arrays;

public class Solution2839 {
    public boolean canBeEqual(String s1, String s2) {
        int[][] a = new int[2][26];
        int[][] b = new int[2][26];
        for (int i = 0; i < s1.length(); i++) {
            a[i % 2][s1.charAt(i) - 'a']++;
            b[i % 2][s2.charAt(i) - 'a']++;
        }
        return Arrays.deepEquals(a, b);
    }
}
