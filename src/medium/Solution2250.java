package medium;

// 2250. Count Number of Rectangles Containing Each Point

import java.util.*;

public class Solution2250 {
    class FenwickTree {
        private int[] tree;

        public FenwickTree(int n) {
            tree = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i < tree.length) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int ans = 0;
            while (i > 0) {
                ans += tree[i];
                i -= lowbit(i);
            }
            return ans;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }


    public int[] countRectangles(int[][] rectangles, int[][] points) {
        SortedSet<Integer> hs = new TreeSet<>();
        SortedSet<Integer> vs = new TreeSet<>();
        for (int[] rec : rectangles) {
            hs.add(rec[0]);
            vs.add(rec[1]);
        }
        for (int[] point : points) {
            hs.add(point[0]);
            vs.add(point[1]);
        }
        List<Integer> h = new ArrayList<>(hs);
        List<Integer> v = new ArrayList<>(vs);
        int[][] diff = new int[h.size() + 1][v.size() + 1];
        for (int[] rec : rectangles) {
            int x = Collections.binarySearch(h, rec[0]);
            int y = Collections.binarySearch(v, rec[1]);
            diff[0][0] += 1;
            diff[x + 1][0] -= 1;
            diff[0][y + 1] -= 1;
            diff[x + 1][y + 1] += 1;
        }
        int[][] f = new int[h.size()][v.size()];
        for (int i = 0; i < diff.length; i++)
            for (int j = 0; j < diff[0].length; j++) {
                int a = i == 0 ? 0 : f[i - 1][j];
                int b = j == 0 ? 0 : f[i][j - 1];
                int c = i == 0 || j == 0 ? 0 : f[i - 1][j - 1];
                f[i][j] = a + b - c + diff[i][j];
            }

        List<Integer> ans = new ArrayList<>();
        for (int[] point : points) {
            int x = Collections.binarySearch(h, point[0]);
            int y = Collections.binarySearch(v, point[1]);
            ans.add(f[x][y]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
