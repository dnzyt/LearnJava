package medium;

// 3170. Lexicographically Minimum String After Removing Stars

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3170 {
    public String clearStars(String s) {
        List<Integer>[] sts = new ArrayList[26];
        Arrays.setAll(sts, k -> new ArrayList<>());
        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '*') {
                for (List<Integer> st : sts) {
                    if (!st.isEmpty()) {
                        int idx = st.remove(st.size() - 1);
                        chs[idx] = '*';
                        break;
                    }
                }
            } else {
                sts[chs[i] - 'a'].add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chs) {
            if (c == '*') continue;
            sb.append(c);
        }
        return sb.toString();

    }
}
