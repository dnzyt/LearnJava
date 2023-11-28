package medium;

// 322. Coin Change

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        Queue<Integer> q = new LinkedList<>();
        int steps = 0;
        Set<Integer> visited = new HashSet<>();
        q.add(amount);

        while (!q.isEmpty()) {
            int l = q.size();
            steps ++;
            while (l > 0) {
                int curr = q.poll();
                l --;
                if (visited.contains(curr))
                    continue;
                visited.add(curr);
                for (int coin : coins) {
                    int r = curr - coin;
                    if (r < 0 || visited.contains(r))
                        continue;
                    if (r == 0)
                        return steps;
                    q.offer(r);
                }
            }
        }
        return -1;
    }

}
