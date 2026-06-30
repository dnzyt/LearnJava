package easy;

// 1189. Maximum Number of Balloons

import java.util.HashMap;
import java.util.Map;

public class Solution1189 {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char ch : text.toCharArray())
            cnt.merge(ch, 1, Integer::sum);
        int ans = Integer.MAX_VALUE;
        for (char c : "balon".toCharArray()) {
            if (c == 'l' || c == 'o')
                ans = Math.min(ans, cnt.getOrDefault(c, 0) / 2);
            else
                ans = Math.min(ans, cnt.getOrDefault(c, 0));
        }
        return ans;
    }
}
