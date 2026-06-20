package medium;

// 3159. Find Occurrences of an Element in an Array

import java.util.ArrayList;
import java.util.List;

public class Solution3159 {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] ans = new int[queries.length];
        List<Integer> s = new ArrayList<>();
        s.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x)
                s.add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > s.size() - 1)
                ans[i] = -1;
            else
                ans[i] = s.get(queries[i]);
        }
        return ans;
    }
}
