package hard;

// 587. Erect the Fence

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution587 {
    // Jarvis 凸包
    public int[][] outerTrees(int[][] trees) {
        int leftMost = 0;
        int n = trees.length;
        if (n < 4)
            return trees;
        for (int i = 0; i < n; i++) {
            if (trees[leftMost][0] > trees[i][0] ||
                    trees[leftMost][0] == trees[i][0] && trees[leftMost][1] > trees[i][1])
                leftMost = i;
        }
        List<int[]> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        // visited[leftMost] = true;
        // res.add(trees[leftMost]);

        int p = leftMost;
        do {
            int q = (p + 1) % n;
            for (int r = 0; r < n; r++) {
                if (getArea(trees[p], trees[q], trees[r]) > 0)
                    q = r;
            }
            for (int r = 0; r < n; r++) {
                if (visited[r] || r == p || r == q)
                    continue;
                if (getArea(trees[p], trees[q], trees[r]) == 0) {
                    visited[r] = true;
                    res.add(trees[r]);
                }
            }
            if (!visited[q]) {
                res.add(trees[q]);
                visited[q] = true;
            }
            p = q;
        } while (p != leftMost);
        return res.toArray(new int[][]{});
    }

    private int crossProduct(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }

    //Andrew 凸包
    private int[] substraction(int[] a, int[] b) {
        return new int[]{a[0] - b[0], a[1] - b[1]};
    }

    private int cross(int[] a, int[] b) {
        return a[0] * b[1] - a[1] * b[0];
    }

    // r在向量pq的右侧时面积大于0
    // r在向量pq的左侧时面积小于0
    private int getArea(int[] p, int[] q, int[] r) {
        return cross(substraction(q, p), substraction(r, p));
    }

    public int[][] outerTrees2(int[][] trees) {
        Arrays.sort(trees, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
        int n = trees.length;

        int top = 0;
        int[] stk = new int[n + 2];
        boolean[] visited = new boolean[n];
        stk[++top] = 0;
        for (int i = 1; i < n; i++) {
            while (top >= 2) {
                int[] p = trees[stk[top - 1]];
                int[] q = trees[stk[top]];
                int[] r = trees[i];
                if (getArea(p, q, r) > 0)
                    visited[stk[top--]] = false;
                else
                    break;
            }
            stk[++top] = i;
            visited[i] = true;
        }
        int size = top;
        for (int i = n - 1; i >= 0; i--) {
            if (visited[i])
                continue;
            while (top > size) {
                int[] p = trees[stk[top - 1]];
                int[] q = trees[stk[top]];
                int[] r = trees[i];
                if (getArea(p, q, r) > 0)
                    top--;
                else
                    break;
            }
            stk[++top] = i;
        }
        int[][] ans = new int[top - 1][2];
        for (int i = 1; i < top; i++)
            ans[i] = trees[stk[i]];
        return ans;
    }

}
