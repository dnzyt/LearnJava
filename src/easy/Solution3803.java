package easy;

// 3803. Count Residue Prefixes

import java.util.HashSet;
import java.util.Set;

public class Solution3803 {
    public int residuePrefixes(String s) {
        Set<Character> st = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            st.add(s.charAt(i));
            if (st.size() >= 3) break;
            if (st.size() == (i + 1) % 3)
                ans++;
        }
        return ans;
    }
}
