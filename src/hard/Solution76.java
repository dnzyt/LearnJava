package hard;

// 76. Minimum Window Substring

import java.util.HashMap;
import java.util.Map;

public class Solution76 {

    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        Map<Character, Integer> counterT = new HashMap<>();
        for (int i = 0; i < tt.length; i++) {
            int num = counterT.computeIfAbsent(tt[i], k -> 0);
            counterT.put(tt[i], num + 1);
        }

        Map<Character, Integer> counterS = new HashMap<>();

        int lengthAdded = 0;
        String res = "";
        int j = 0;
        for (int i = 0; i < ss.length; i++) {
            Character curr = ss[i];
            if (!counterT.containsKey(curr)) continue;
            int currCount = counterS.computeIfAbsent(curr, k -> 0) + 1;
            counterS.put(curr, currCount);
            if (currCount == counterT.get(curr))
                lengthAdded ++;


            while (lengthAdded == counterT.size()) {
                if (res.isEmpty() || res.length() > (i - j + 1))
                    res = s.substring(j, i + 1);
                if (!counterT.containsKey(ss[j]))
                    j ++;
                else {
                    counterS.put(ss[j], counterS.get(ss[j]) - 1);
                    if (counterS.get(ss[j]) < counterT.get(ss[j])) {
                        lengthAdded--;
                    }
                    j ++;
                }
            }
        }
        return res;
    }
}
