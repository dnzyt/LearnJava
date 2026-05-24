package hard;

// 1340. Jump Game V

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1340 {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();
            left[i] = (st.isEmpty() || i - st.peek() > d) ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();
            right[i] = (st.isEmpty() || st.peek() - i > d) ? -1 : st.peek();
            st.push(i);
        }

        int ans = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, left, right, dp));
        }
        return ans;
    }

    private int dfs(int i, int[] left, int[] right, int[] dp) {
        if (i == -1)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        return dp[i] = Math.max(dfs(left[i], left, right, dp), dfs(right[i], left, right, dp)) + 1;
    }
}
