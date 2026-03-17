package hard;

// 3873. Maximum Points Activated with One Addition

import java.util.*;

public class Solution3873 {
    private int[] pa;

    public int maxActivated(int[][] points) {
        SortedSet<Integer> xSet = new TreeSet<>();
        SortedSet<Integer> ySet = new TreeSet<>();
        for (int[] point : points) {
            xSet.add(point[0]);
            ySet.add(point[1]);
        }
        List<Integer> xMap = new ArrayList<>(xSet);
        List<Integer> yMap = new ArrayList<>(ySet);

        int n = xMap.size() + yMap.size();
        pa = new int[n + 1];
        for (int i = 0; i <= n; i++)
            pa[i] = i;
        for (int[] point : points) {
            int xIdx = Collections.binarySearch(xMap, point[0]);
            int yIdx = Collections.binarySearch(yMap, point[1]) + xMap.size();
            pa[find(xIdx)] = find(yIdx);
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] point : points) {
            int f = find(Collections.binarySearch(xMap, point[0]));
            cnt.merge(f, 1, Integer::sum);
        }
        int mx1 = 0, mx2 = 0;
        for (int num : cnt.values()) {
            if (num >= mx1) {
                mx2 = mx1;
                mx1 = num;
            } else if (num > mx2)
                mx2 = num;
        }
        return mx1 + mx2 + 1;
    }

    private int find(int x) {
        if (x != pa[x])
            pa[x] = find(pa[x]);
        return pa[x];
    }
}
