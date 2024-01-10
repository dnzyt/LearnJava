package medium;

// 721. Accounts Merge

import java.util.*;



public class Solution721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Set<String> emails = new HashSet<>();
        Map<String, String> emailToName = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                emails.add(account.get(i));
                emailToName.put(account.get(i), name);
            }
        }
        UF uf = new UF(emails.stream().toList());
        for (List<String> account : accounts) {
            String s = account.get(1);
            for (int i = 2; i < account.size(); i++)
                uf.union(s, account.get(i));
        }
        Map<String, List<String>> res = new HashMap<>();
        for (String email : emails) {
            String pa = uf.find(email);
            res.computeIfAbsent(pa, (k -> new ArrayList<>())).add(email);
        }
        List<List<String>> r = new ArrayList<>();
        res.forEach((k, v) -> {
            List<String> t = new ArrayList<>();
            Collections.sort(v);
            t.add(emailToName.get(k));
            t.addAll(v);
            r.add(t);
        });

        return r;

    }

    static class UF {
        Map<String, String> parents;

        public UF(List<String> ss) {
            parents = new HashMap<>();
            for (String s : ss) {
                parents.put(s, s);
            }
        }

        public String find(String a) {
            while (!a.equals(parents.get(a)))
                parents.put(a, find(parents.get(a)));
            return parents.get(a);
        }

        public void union(String a, String b) {
            String pa = find(a);
            String pb = find(b);
            if (!pa.equals(pb))
                parents.put(pa, pb);
        }
    }

}
