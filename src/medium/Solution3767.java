package medium;

// 3767. Maximize Points After Choosing K Tasks


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution3767 {

    public long maxPoints(int[] technique1, int[] technique2, int k) {
        int n = technique1.length;
        List<Integer> d = new ArrayList<>();
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            int x = technique2[i] - technique1[i];
            if (x > 0)
                d.add(x);
            ans += technique1[i];
        }
        d.sort(Collections.reverseOrder());
        for (int i = 0; i < Math.min(n - k, d.size()); i++) {
            ans += d.get(i);
        }
        return ans;
    }

}
