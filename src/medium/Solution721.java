package medium;

// 721. Accounts Merge

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution721 {
    private Map<String, String> pa;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        pa = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        for (List<String> s : accounts) {
            String name = s.getFirst();
            for (int i = 1; i < s.size(); i++) {
                emailToName.put(s.get(i), name);
                pa.put(s.get(i), s.get(i));
            }
        }

        for (List<String> s : accounts) {
            String t = s.get(1);
            for (int i = 2; i < s.size(); i++)
                merge(t, s.get(i));
        }


        Map<String, List<String>> map = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String parent = find(email);
            if (!map.containsKey(parent))
                map.put(parent, new ArrayList<>());
            map.get(parent).add(email);
        }

        List<List<String>> ans = new ArrayList<>();
        for (String email : map.keySet()) {
            List<String> t = new ArrayList<>();
            map.get(email).sort(String::compareTo);
            t.add(emailToName.get(email));
            t.addAll(map.get(email));
            ans.add(t);
        }
        return ans;

    }


    public String find(String x) {
        if (!x.equals(pa.get(x)))
            pa.put(x, find(pa.get(x)));
        return pa.get(x);
    }

    public boolean merge(String a, String b) {
        String x = find(a);
        String y = find(b);
        if (x.equals(y))
            return false;
        pa.put(x, y);
        return true;
    }


}
