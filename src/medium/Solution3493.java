package medium;

// 3493. Properties Graph

import util.UnionFind;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution3493 {
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        Set<Integer>[] p = new HashSet[n];
        for (int i = 0; i < n; i++)
            p[i] = new HashSet<>(IntStream.of(properties[i]).boxed().toList());
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                Set<Integer> intersection = new HashSet<>(p[i]);
                intersection.retainAll(p[j]);
                if (intersection.size() >= k)
                    uf.merge(i, j);
            }
        return uf.count;
    }
}
