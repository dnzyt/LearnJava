package hard;

// 1526. Minimum Number of Increments on Subarrays to Form a Target Array

import java.util.stream.IntStream;

public class Solution1526 {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int[] diff = new int[n + 1];
        diff[0] = target[0];
        for (int i = 1; i < n; i++)
            diff[i] = target[i] - target[i - 1];
        int count = 0;
        for (int i = 0; i < n; i++)
            count += Math.max(0, diff[i]);
        return count;
    }
}
