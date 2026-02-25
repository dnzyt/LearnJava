package hard;

// 1483. Kth Ancestor of a Tree Node

public class Solution1843 {
    class TreeAncestor {

        private int[][] pa;

        public TreeAncestor(int n, int[] parent) {
            int m = 32 - Integer.numberOfLeadingZeros(n);
            pa = new int[n][m];
            for (int i = 0; i < n; i++)
                pa[i][0] = parent[i];

            for (int x = 0; x < m - 1; x++) {
                for (int i = 0; i < n; i++) {
                    int parentNode = pa[i][x];
                    if (parentNode == -1)
                        pa[i][x + 1] = -1;
                    else
                        pa[i][x + 1] = pa[parentNode][x];
                }
            }

        }

        public int getKthAncestor(int node, int k) {
            int n = 32 - Integer.numberOfLeadingZeros(k);
            for (int i = 0; i < n; i++) {
                if (((k >> i) & 1) > 0) {
                    node = pa[node][i];
                    if (node == -1)
                        break;
                }
            }
            return node;
        }
    }
}
