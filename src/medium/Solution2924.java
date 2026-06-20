package medium;

// 2924. Find Champion II

public class Solution2924 {
    public int findChampion(int n, int[][] edges) {
        int[] indegrees = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            indegrees[v]++;
        }
        int cnt = 0, ch = 0;
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                cnt++;
                ch = i;
            }
        }
        return cnt == 0 ? ch : -1;
    }
}
