package medium;

// 438. Find All Anagrams in a String

import java.util.*;

public class Solution438 {

    // 双指针 + 计数器
    public List<Integer> findAnagrams(String s, String p) {
        Set<Character> set = new HashSet<>();
        for (Character x : p.toCharArray())
            set.add(x);

        int[] counter = new int[26];
        for (char x : p.toCharArray()) {
            counter[x - 97] += 1;
        }
        int remain = p.length();
        List<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!set.contains(curr)) {
                while (j < i) {
                    counter[s.charAt(j) - 97] += 1;
                    j ++;
                }
                remain = p.length();
                j ++;
                continue;
            }

            if (counter[curr - 97] > 0) {
                counter[curr - 97] -= 1;
                remain -= 1;

            } else if (counter[curr - 97] == 0) {
                while (s.charAt(j) != curr) {
                    counter[s.charAt(j) - 97] += 1;
                    remain += 1;
                    j += 1;
                }
                j += 1;
            }
            if (remain == 0)
                res.add(j);
        }

        return res;
    }

}
