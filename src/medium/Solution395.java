package medium;

// 395. Longest Substring with At Least K Repeating Characters

import java.util.HashMap;
import java.util.Map;

public class Solution395 {

    public int longestSubstring(String s, int k) {
        // 分别求出子串中只有1种字符，2种字符，3种字符。。。26种字符时，每个字符至少出现k次的最长字串
        int res = 0;
        for (int i = 1; i <= 26; i++) {
            Map<Character, Integer> counter = new HashMap<>();
            // 字符出现次数>=k次的字符种类
            int satisfy = 0;
            int l = 0;
            // sliding window
            // 当窗口种字符种类比i大时，把左边向右移动来缩小窗口，使窗口包含的字符种类再次<=i
            for (int r = 0; r < s.length(); r++) {
                Character curr = s.charAt(r);
                if (!counter.containsKey(curr))
                    counter.put(curr, 0);
                int num = counter.get(curr);
                counter.put(curr, num + 1);
                if (num + 1 == k) satisfy += 1;
                while (counter.size() > i) {
                    Character left = s.charAt(l);
                    int temp = counter.get(left);
                    counter.put(left, temp - 1);
                    if (temp - 1 == 0)
                        counter.remove(left);
                    if (temp == k) satisfy -= 1;
                    l += 1;
                }
                if (satisfy == i)
                    res = Math.max(res, r - l + 1);
            }
        }

        return res;

    }

}
