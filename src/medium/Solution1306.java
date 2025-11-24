package medium;

// 1306. Jump Game III

public class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start, new boolean[arr.length]);
    }

    private boolean dfs(int[] arr, int i, boolean[] visited) {
        if (arr[i] == 0)
            return true;
        if (i - arr[i] >= 0 && !visited[i - arr[i]]) {
            visited[i - arr[i]] = true;
            if (dfs(arr, i - arr[i], visited))
                return true;
        }
        if (i + arr[i] < arr.length && !visited[i + arr[i]]) {
            visited[i + arr[i]] = true;
            if (dfs(arr, i + arr[i], visited))
                return true;
        }
        return false;
    }
}
