package medium;

// 475. Heaters

import java.util.Arrays;

public class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int j = 0;
        for (int i = 0; i < houses.length; i++) {
            while (!isBest(houses, heaters, i, j))
                j += 1;
            res = Math.max(res, Math.abs(houses[i] - heaters[j]));
        }

        return res;
    }

    private boolean isBest(int[] houses, int[] heaters, int i, int j) {
        return j == heaters.length - 1 || Math.abs(houses[i] - heaters[j]) < Math.abs(houses[i] - heaters[j + 1]);
    }
}
