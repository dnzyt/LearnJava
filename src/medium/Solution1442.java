package medium;

// 1442. Count Triplets That Can Form Two Arrays of Equal XOR

import java.util.HashMap;
import java.util.Map;

public class Solution1442 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++)
            presum[i + 1] = presum[i] ^ arr[i];
        map.merge(0, 1, Integer::sum);
        for (int j = 1; j < n; j++) {
            for (int k = j; k < n; k++) {
                if (map.containsKey(presum[k + 1]))
                    ans += map.get(presum[k + 1]);
            }
            map.merge(presum[j], 1, Integer::sum);
        }

        return ans;
    }
}
