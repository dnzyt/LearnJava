package medium;

// 1371. Find the Longest Substring Containing Vowels in Even Counts

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1371 {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        List<Integer> la = new ArrayList<>();
        List<Integer> le = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        List<Integer> lo = new ArrayList<>();
        List<Integer> lu = new ArrayList<>();
        int ca = 0, ce = 0, ci = 0, co = 0, cu = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == 'a')
                ca ++;
            else if (ch == 'e')
                ce ++;
            else if (ch == 'i')
                ci ++;
            else if (ch == 'o')
                co ++;
            else if (ch == 'u')
                cu ++;
            la.add(ca);
            le.add(ce);
            li.add(ci);
            lo.add(co);
            lu.add(cu);
        }
        int res = 0;
        Map<String, Integer> m = new HashMap<>();
        m.put("00000", -1);
        for (int i = 0; i < n; i++) {
            String patter = String.valueOf(la.get(i) % 2 == 0 ? '0' : '1') +
                    (le.get(i) % 2 == 0 ? '0' : '1') +
                    (li.get(i) % 2 == 0 ? '0' : '1') +
                    (lo.get(i) % 2 == 0 ? '0' : '1') +
                    (lu.get(i) % 2 == 0 ? '0' : '1');
            if (m.containsKey(patter)) {
                res = Math.max(res, i - m.get(patter));
            } else {
                m.put(patter, i);
            }
        }
        return res;
    }
}
