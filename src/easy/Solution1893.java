package easy;

// 1893. Check if All the Integers in a Range Are Covered

import java.util.Arrays;

public class Solution1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[100];
        for (int[] r : ranges) {
            diff[r[0]] += 1;
            diff[r[1] + 1] -= 1;
        }
        int s = 0;
        for (int i = 0; i < diff.length; i++) {
            s += diff[i];
            if (left <= i && i <= right && s <= 0)
                return false;
        }
        return true;
    }
}
