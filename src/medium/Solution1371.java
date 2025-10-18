package medium;

// 1371. Find the Longest Substring Containing Vowels in Even Counts

import java.util.*;

public class Solution1371 {
    public int findTheLongestSubstring(String s) {
        int[] map = new int[32];
        Arrays.fill(map, -2);
        map[0] = -1;
        int res = 0;
        int status = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int m = move(curr);
            if (m != -1)
                status ^= (1 << m);
            if (map[status] != -2)
                res = Math.max(res, i - map[status]);
            else
                map[status] = i;
        }
        return res;
    }

    private int move(char ch) {
        return switch (ch) {
            case 'a' -> 0;
            case 'e' -> 1;
            case 'i' -> 2;
            case 'o' -> 3;
            case 'u' -> 4;
            default -> -1;
        };
    }


    public int findTheLongestSubstring1(String s) {
        int n = s.length();
        List<Integer> la = new ArrayList<>();
        List<Integer> le = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        List<Integer> lo = new ArrayList<>();
        List<Integer> lu = new ArrayList<>();
        int ca = 0, ce = 0, ci = 0, co = 0, cu = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == 'a')
                ca++;
            else if (ch == 'e')
                ce++;
            else if (ch == 'i')
                ci++;
            else if (ch == 'o')
                co++;
            else if (ch == 'u')
                cu++;
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

    // 前缀异或和+哈希
    public int findTheLongestSubstring3(String s) {
        int n = s.length();
        int[] presum = new int[n + 1];
        char[] c = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int idx = convert(c[i]);
            if (idx == -1)
                presum[i + 1] = presum[i];
            else
                presum[i + 1] = presum[i] ^ (1 << idx);
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(presum[i + 1])) {
                int l = map.get(presum[i + 1]);
                ans = Math.max(ans, i - l);
            } else {
                map.put(presum[i + 1], i);
            }
        }
        return ans;
    }

    private int convert(char a) {
        return switch (a) {
            case 'a' -> 0;
            case 'e' -> 1;
            case 'i' -> 2;
            case 'o' -> 3;
            case 'u' -> 4;
            default -> -1;
        };
    }


}
