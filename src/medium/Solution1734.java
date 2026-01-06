package medium;

// 1734. Decode XORed Permutation

import java.util.ArrayList;
import java.util.List;

public class Solution1734 {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum ^= i;
        for (int i = 1; i < n; i += 2)
            sum ^= encoded[i];
        List<Integer> ans = new ArrayList<>();
        ans.add(sum);
        for (int i = 0; i < encoded.length; i++) {
            sum ^= encoded[i];
            ans.add(sum);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
