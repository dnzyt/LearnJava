package easy;

// 2423. Remove Letter To Equalize Frequency

import java.util.HashMap;
import java.util.Map;

public class Solution2423 {
    // O(n^2)
    // O(n)的写法是1224题
    public boolean equalFrequency(String word) {
        Map<Character, Integer> cnt = new HashMap<>();
        char[] w = word.toCharArray();
        int n = w.length;
        for (int i = 0; i < n; i++) {
            cnt.clear();
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                cnt.merge(w[j], 1, Integer::sum);
            }
            if (isSame(cnt))
                return true;
        }
        return false;
    }

    private boolean isSame(Map<Character, Integer> cnt) {
        int num = cnt.entrySet().iterator().next().getValue();
        for (int c : cnt.values())
            if (c != num)
                return false;
        return true;
    }
}
