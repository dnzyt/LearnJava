package medium;

// 2477. Minimum Fuel Cost to Report to the Capital

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2477 {

    private List<Integer>[] g;
    private int seats;
    private long ans;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        this.seats = seats;
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] r : roads) {
            g[r[0]].add(r[1]);
            g[r[1]].add(r[0]);
        }
        dfs(0, -1);
        return ans;
    }

    // [numOfCars, numOfPeoples]
    private int dfs(int i, int fa) {
        int peoples = 1;
        for (int nxt : g[i]) {
            if (nxt == fa)
                continue;
            peoples += dfs(nxt, i);
        }
        if (i != 0)
            ans += (peoples + seats - 1) / seats;
        return peoples;
    }
}
