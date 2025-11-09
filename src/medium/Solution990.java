package medium;

// 990. Satisfiability of Equality Equations

import util.UnionFind;

import java.util.ArrayList;
import java.util.List;

public class Solution990 {
    public boolean equationsPossible(String[] equations) {
        List<String> unequals = new ArrayList<>();
        UnionFind uf = new UnionFind(26);
        for (String e : equations) {
            if (e.charAt(1) == '!')
                unequals.add(e);
            else {
                int a = e.charAt(0) - 'a';
                int b = e.charAt(3) - 'a';
                uf.merge(a, b);
            }
        }
        for (String s : unequals) {
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            if (uf.find(a) == uf.find(b))
                return false;
        }
        return true;
    }
}
