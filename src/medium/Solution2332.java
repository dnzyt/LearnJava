package medium;

// 2332. The Latest Time to Catch a Bus

import java.util.Arrays;

public class Solution2332 {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int c = 0, j = 0;
        for (int i = 0; i < buses.length; i++) {
            int bus = buses[i];
            c = capacity;
            while (c > 0 && j < passengers.length && passengers[j] <= bus) {
                j++;
                c--;
            }
        }
        j--; // j以及之前的人都能走
        int ans = c > 0 ? buses[buses.length - 1] : passengers[j];
        while (j >= 0 && passengers[j] == ans) {
            ans--;
            j--;
        }
        return ans;
    }
}
