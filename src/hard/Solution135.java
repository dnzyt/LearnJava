package hard;

// 135. Candy

import java.util.Arrays;

public class Solution135 {
    public int candy(int[] ratings) {
        int pre = 1, inc = 1, dec = 0;
        int ans = 1;
        int n = ratings.length;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] <= ratings[i]) {
                dec = 0;
                pre = ratings[i - 1] == ratings[i] ? 1 : pre + 1;
                inc = pre;
                ans += pre;
            } else {
                dec++;
                if (dec == inc)
                    dec++;
                ans += dec;
                pre = 1;
            }
        }
        return ans;
    }

    public int candy2(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                left[i] = Math.max(left[i + 1] + 1, left[i]);
        }
        return Arrays.stream(left).sum();
    }
}
