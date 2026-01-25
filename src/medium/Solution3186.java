package medium;

// 3186. Maximum Total Damage With Spell Casting

import java.util.*;

public class Solution3186 {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> cnt = new HashMap<>();
        for (int p : power)
            cnt.merge(p, (long) p, Long::sum);
        List<Long> s = new ArrayList<>();
        int pre = -10;
        List<Integer> keys = new ArrayList<>(cnt.keySet());
        Collections.sort(keys);
        for (int key : keys) {
            if (key - 1 != pre) {
                s.add(0L);
                if (key - 2 != pre)
                    s.add(0L);
            }
            s.add(cnt.get(key));
            pre = key;
        }

        long f0 = 0L, f1 = 0L, f2 = 0L;
        for (int i = 1; i < s.size(); i++) {
            long newf = Math.max(f0 + s.get(i), f2);
            f0 = f1;
            f1 = f2;
            f2 = newf;
        }
        return f2;
    }
}
