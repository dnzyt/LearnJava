package hard;

// 3878. Count Good Subarrays

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3878 {
    public long countGoodSubarrays(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> segs = new ArrayList<>(); // orVal, index

        long ans = 0l;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            map.put(x, i);
            for (int[] seg : segs)
                seg[0] |= x;
            segs.add(new int[]{x, i});

            int m = 1;
            for (int j = 1; j < segs.size(); j++) {
                if (segs.get(j)[0] != segs.get(j - 1)[0])
                    segs.set(m++, segs.get(j));
            }
            segs.subList(m, segs.size()).clear();

            for (int j = 0; j < segs.size(); j++) {
                int orVal = segs.get(j)[0], left = segs.get(j)[1];
                int right = j + 1 < segs.size() ? segs.get(j + 1)[1] - 1 : i;
                right = Math.min(map.getOrDefault(orVal, -1), right);
                if (left <= right)
                    ans += right - left + 1;
            }
        }
        return ans;
    }
}
