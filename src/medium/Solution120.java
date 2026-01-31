package medium;

// 120. Triangle

import java.util.Arrays;
import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.getLast().size();
        int[] f = new int[n];
        f[0] = triangle.getFirst().getFirst();
        for (int i = 1; i < m; i++) {
            int[] temp = f.clone();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int num = triangle.get(i).get(j);
                int left = Math.max(j - 1, 0);
                int right = Math.min(j, triangle.get(i - 1).size() - 1);
                f[j] = Math.min(temp[left], temp[right]) + num;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int num : f)
            res = Math.min(res, num);
        return res;
    }
}
