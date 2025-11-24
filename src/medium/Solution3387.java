package medium;

// 3387. Maximize Amount After Two Days of Conversions

import javafx.util.Pair;

import java.util.*;

public class Solution3387 {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, List<Pair<String, Double>>> m1 = new HashMap<>();
        for (int i = 0; i < pairs1.size(); i++) {
            List<String> p = pairs1.get(i);
            String start = p.get(0);
            String end = p.get(1);
            if (!m1.containsKey(start))
                m1.put(start, new ArrayList<>());
            if (!m1.containsKey(end))
                m1.put(end, new ArrayList<>());
            m1.get(start).add(new Pair<>(end, rates1[i]));
            m1.get(end).add(new Pair<>(start, 1 / rates1[i]));
        }

        Map<String, List<Pair<String, Double>>> m2 = new HashMap<>();
        for (int i = 0; i < pairs2.size(); i++) {
            List<String> p = pairs2.get(i);
            String start = p.get(0);
            String end = p.get(1);
            if (!m2.containsKey(start))
                m2.put(start, new ArrayList<>());
            if (!m2.containsKey(end))
                m2.put(end, new ArrayList<>());
            m2.get(start).add(new Pair<>(end, rates1[i]));
            m2.get(end).add(new Pair<>(start, 1 / rates1[i]));
        }
        if (!m2.containsKey(initialCurrency))
            return 1.0;
        Map<String, Double> ratio1 = new HashMap<>();
        Map<String, Double> ratio2 = new HashMap<>();
        dfs(m1, initialCurrency, new HashSet<>(), ratio1, 1.0);
        dfs(m2, initialCurrency, new HashSet<>(), ratio2, 1.0);
        double ans = 0;
        for (Map.Entry<String, Double> e : ratio1.entrySet()) {
            if (!ratio2.containsKey(e.getKey()))
                continue;
            ans = Math.max(ans, e.getValue() / ratio2.get(e.getKey()));
        }
        return ans;
    }

    private void dfs(Map<String, List<Pair<String, Double>>> g, String source, Set<String> visited, Map<String, Double> ratio, double prev) {
        visited.add(source);
        for (Pair<String, Double> nxt : g.get(source)) {
            String to = nxt.getKey();
            double rate = nxt.getValue();
            if (visited.contains(to))
                continue;
            ratio.put(to, rate * prev);
            dfs(g, to, visited, ratio, prev * rate);
        }
    }
}
