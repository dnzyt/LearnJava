package medium;

// 2080. Range Frequency Queries

import java.util.*;

public class Solution2080 {
    class RangeFreqQuery {

        private final Map<Integer, List<Integer>> pos;

        public RangeFreqQuery(int[] arr) {
            pos = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (!pos.containsKey(arr[i]))
                    pos.put(arr[i], new ArrayList<>());
                pos.get(arr[i]).add(i);
            }
        }

        public int query(int left, int right, int value) {
            if (!pos.containsKey(value))
                return 0;
            int l = lowerBound(pos.get(value), left);
            int r = lowerBound(pos.get(value), right + 1);
            return r - l;
        }

        private int lowerBound(List<Integer> nums, int target) {
            int left = -1, right = nums.size();
            while (left + 1 < right) {
                int mid = (left + right) >>> 1;
                if (nums.get(mid) >= target)
                    right = mid;
                else
                    left = mid;
            }
            return left;
        }
    }
}
