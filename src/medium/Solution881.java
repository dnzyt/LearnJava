package medium;

// 881. Boats to Save People

import java.util.Arrays;

public class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int res = 0;
        while (l < r) {
            if (people[l] + people[r] <= limit) {
                res += 1;
                l += 1;
                r -= 1;
            } else {
                res += 1;
                r -= 1;
            }
        }
        if (l == r) res += 1;
        return res;
    }
}
