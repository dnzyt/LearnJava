package medium;

// 134. Gas Station

public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = 0;
        int r = 0;
        int sum = 0;
        for (int l = 0; l < gas.length; l++) {
            while (sum >= 0) {
                if (len == gas.length)
                    return l;
                sum += gas[r] - cost[r];
                r = (r + 1) % gas.length;
                len += 1;
            }
            sum -= gas[l] - cost[l];
            len -= 1;
        }
        return -1;
    }

}
