package medium;

// 3629. Minimum Jumps to Reach End via Prime Teleportation

import java.util.*;

public class Solution3629 {

    private static final int MX = 1000000;
    private static boolean initialized = false;
    private static List<Integer>[] PRIME_FACTORS;

    private void init() {
        if (initialized) {
            return;
        }
        initialized = true;
        PRIME_FACTORS = new List[MX + 1];
        Arrays.setAll(PRIME_FACTORS, i -> new ArrayList<>());
        for (int i = 2; i <= MX; i++) {
            if (PRIME_FACTORS[i].size() != 0)
                continue;
            for (int j = i; j <= MX; j += i)
                PRIME_FACTORS[j].add(i);
        }
    }


    public int minJumps(int[] nums) {
        init();
        int n = nums.length;
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int f : PRIME_FACTORS[nums[i]])
                groups.computeIfAbsent(f, x -> new ArrayList<>()).add(i);
        }

        boolean[] visited = new boolean[n];
        List<Integer> q = new ArrayList<>();
        q.add(0);
        visited[0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int idx : q) {
                if (idx == n - 1)
                    return ans;
                List<Integer> nxtMoves = groups.computeIfAbsent(nums[idx], x -> new ArrayList<>());
                nxtMoves.add(idx + 1);
                if (idx > 0)
                    nxtMoves.add(idx - 1);
                for (int move : nxtMoves) {
                    if (visited[move])
                        continue;
                    visited[move] = true;
                    tmp.add(move);
                }
                nxtMoves.clear();
            }
            q = tmp;
            ans++;
        }

        return -1;
    }
}
