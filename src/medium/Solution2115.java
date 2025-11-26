package medium;

// 2115. Find All Possible Recipes from Given Supplies

import java.util.*;

public class Solution2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> rs = new HashSet<>(Arrays.stream(recipes).toList());
        Set<String> sps = new HashSet<>(Arrays.stream(supplies).toList());
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> g = new HashMap<>();

        int n = recipes.length;
        for (int i = 0; i < n; i++) {
            String rec = recipes[i];
            List<String> ingre = ingredients.get(i);
            indegree.put(rec, ingre.size());
            for (String x : ingre) {
                if (!g.containsKey(x))
                    g.put(x, new ArrayList<>());
                g.get(x).add(rec);
            }
        }
        Queue<String> q = new ArrayDeque<>();
        for (String k : g.keySet()) {
            if (!indegree.containsKey(k) && sps.contains(k))
                q.add(k);
        }

        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            Queue<String> t = new ArrayDeque<>();
            while (!q.isEmpty()) {
                String x = q.poll();
                if (rs.contains(x))
                    ans.add(x);
                if (!g.containsKey(x))
                    continue;
                for (String nxt : g.get(x)) {
                    indegree.merge(nxt, -1, Integer::sum);
                    if (indegree.get(nxt) == 0)
                        t.offer(nxt);
                }
            }
            q = t;
        }
        return ans;
    }
}
