package medium;

// 399. Evaluate Division

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution399 {
    private Map<String, Double> dist;
    private Map<String, String> parent;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        dist = new HashMap<>();
        parent = new HashMap<>();
        int n = values.length;
        for (int i = 0; i < n; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            if (!parent.containsKey(a)) {
                parent.put(a, a);
                dist.put(a, 1.0);
            }
            if (!parent.containsKey(b)) {
                parent.put(b, b);
                dist.put(b, 1.0);
            }
            merge(a, b, val);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            if (!parent.containsKey(a) || !parent.containsKey(b)) {
                ans[i] = -1.0;
                continue;
            }
            String pa = find(a);
            String pb = find(b);
            if (!pa.equals(pb))
                ans[i] = -1.0;
            else
                ans[i] = dist.get(a) / dist.get(b);
        }
        return ans;
    }

    private String find(String a) {
        String tmp = parent.get(a);
        double d = dist.get(a);
        if (!a.equals(tmp)) {
            parent.put(a, find(tmp));
            double t = dist.get(tmp);
            dist.put(a, d * t);
        }
        return parent.get(a);
    }

    private boolean merge(String a, String b, double val) {
        String pa = find(a);
        String pb = find(b);
        if (pa.equals(pb))
            return false;
        parent.put(pa, pb);
        dist.put(pa, val * dist.get(b) / dist.get(a));
        return true;
    }
}
