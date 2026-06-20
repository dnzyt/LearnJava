package hard;

// 2306. Naming a Company

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2306 {
    public long distinctNames(String[] ideas) {
        Set<String>[] g = new Set[26];
        Arrays.setAll(g, i -> new HashSet<>());
        for (String idea : ideas) {
            g[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        long ans = 0;
        for (int a = 1; a < 26; a++) {
            for (int b = 0; b < a; b++) {
                int m = 0;
                for (String s : g[a]) {
                    if (g[b].contains(s))
                        m++;
                }
                ans += (g[a].size() - m) * (g[b].size() - m) * 2;
            }
        }
        return ans;
    }
}
