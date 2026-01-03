package easy;

// 1018. Binary Prefix Divisible By 5

import java.util.ArrayList;
import java.util.List;

public class Solution1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int s = 0;
        for (int num : nums) {
            s = (s << 1 | num) % 5;
            ans.add(s == 0);
        }
        return ans;
    }
}
