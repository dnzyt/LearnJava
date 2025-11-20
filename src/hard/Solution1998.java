package hard;

// 1998. GCD Sort of an Array

import util.UnionFind;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution1998 {
    private static final int MX = 100000;

    public boolean gcdSort(int[] nums) {
        int n = nums.length;
        int[] lpf = new int[MX + 1];
        lpf[1] = 1;
        for (int i = 2; i <= MX; i++) {
            if (lpf[i] != 0) continue;
            lpf[i] = i;
            for (int j = i * i; j > 0 && j <= MX; j += i) {
                if (lpf[j] == 0)
                    lpf[j] = i;
            }
        }

        UnionFind uf = new UnionFind(n + MX);
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (x > 1) {
                int p = lpf[x];
                while (p == lpf[x])
                    x /= p;
                uf.merge(i, n + p);
            }
        }

        List<int[]> s = IntStream.range(0, n)
                .mapToObj(i -> new int[]{nums[i], i})
                .sorted(Comparator.comparingInt(a -> a[0]))
                .toList();
        for (int i = 0; i < s.size(); i++) {
            int a = s.get(i)[1];
            int b = i;
            if (uf.find(a) != uf.find(b))
                return false;
        }
        return true;
    }
}
