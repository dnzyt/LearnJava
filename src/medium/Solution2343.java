package medium;

// 2343. Query Kth Smallest Trimmed Number

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution2343 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0], trim = queries[i][1];
            List<String> s = new ArrayList<>();
            for (String num : nums)
                s.add(num.substring(num.length() - trim));
            Integer[] ids = IntStream.range(0, n).boxed().toArray(Integer[]::new);
            Arrays.sort(ids, (a, b) -> s.get(a).compareTo(s.get(b)));
            ans[i] = ids[k - 1];
        }
        return ans;
    }
}
