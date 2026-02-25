package hard;

// 3501. Maximize Active Section with Trade II

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution3501 {
    // 左闭右开
    private record Pair(int l, int r) {
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        List<Pair> a = new ArrayList<>();
        a.add(new Pair(-1, -1));
        int total1 = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || chs[i] != chs[i + 1]) {
                if (chs[i] == '1') {
                    total1 += i - start + 1;
                } else if (chs[i] == '0') {
                    a.add(new Pair(start, i + 1));
                }
                start = i + 1;
            }
        }
        a.add(new Pair(n + 1, n + 1));

        SparseTable st = new SparseTable(a);
        List<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int ql = query[0], qr = query[1] + 1;

            int i = Collections.binarySearch(a, new Pair(ql, 0), (x, y) -> x.l - y.l);
            if (i < 0) i = ~i;
            int j = Collections.binarySearch(a, new Pair(0, qr + 1), (x, y) -> x.r - y.r);
            if (j < 0) j = ~j;
            j--;
            int mx = 0;
            if (i <= j) {
                int full = st.query(i, j);
                int leftFragment = merge(a.get(i - 1).r - ql, a.get(i).r - a.get(i).l);
                int rightFragment = merge(a.get(j).r - a.get(j).l, qr - a.get(j + 1).l);
                mx = Math.max(full, Math.max(leftFragment, rightFragment));
            } else if (i == j + 1) { // 左边残缺 + 右边残缺
                mx = merge(a.get(i - 1).r - ql, qr - a.get(j + 1).l);
            }
            ans.add(total1 + mx);
        }
        return ans;
    }

    private class SparseTable {
        private int[][] st;

        public SparseTable(List<Pair> a) {
            int n = a.size() - 1;
            int sz = 32 - Integer.numberOfLeadingZeros(n);
            st = new int[n][sz];
            for (int i = 0; i < n; i++) {
                st[i][0] = (a.get(i).r - a.get(i).l) + (a.get(i + 1).r - a.get(i + 1).l);
            }
            for (int p = 1; p < sz; p++) {
                for (int i = 0; i + (1 << p) <= n; i++) {
                    st[i][p] = Math.max(st[i][p - 1], st[i + (1 << (p - 1))][p - 1]);
                }
            }
        }

        // 左闭右开
        public int query(int l, int r) {
            if (l >= r) return 0;
            int k = 32 - Integer.numberOfLeadingZeros(r - l);
            return Math.max(st[l][k - 1], st[r - (1 << (k - 1))][k - 1]);
        }
    }

    private int merge(int x, int y) {
        return x > 0 && y > 0 ? x + y : 0;
    }
}
