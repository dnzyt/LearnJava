package easy;

// 4065. Rearrange Array by Removing Distinct Values

import java.util.ArrayList;
import java.util.List;

public class Solution4065 {
    public int[] rearrangeArray(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums)
            cnt[num]++;

        List<Integer> ans = new ArrayList<>();
        while (ans.size() != nums.length) {
            for (int x = 0; x <= 100; x++) {
                if (cnt[x] > 0) {
                    ans.add(x);
                    cnt[x]--;
                }
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
