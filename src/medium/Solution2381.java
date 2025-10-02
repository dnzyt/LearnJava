package medium;

// 2381. Shifting Letters II

public class Solution2381 {
    // 差分
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];
        for (int[] a : shifts) {
            int left = a[0];
            int right = a[1];
            int dir = a[2];
            diff[left] += (dir == 0 ? -1 : 1);
            diff[right + 1] += (dir == 0 ? 1 : -1);
        }

        char[] c = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            sum += diff[i];
            c[i] = (char) (((c[i] - 'a' + sum) % 26 + 26) % 26 + 'a');
        }

        return new String(c);
    }
}
