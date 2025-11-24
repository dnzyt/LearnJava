package medium;

// 841. Keys and Rooms

import java.util.List;

public class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(rooms, 0, visited);
        for (boolean x : visited)
            if (!x)
                return false;
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int i, boolean[] visited) {
        for (int x : rooms.get(i)) {
            if (!visited[x]) {
                visited[x] = true;
                dfs(rooms, x, visited);
            }
        }
    }
}
