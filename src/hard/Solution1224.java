package hard;

// 1224. Maximum Equal Frequency

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution1224 {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> freq2cnt = new HashMap<>();
        Map<Integer, Integer> num2freq = new HashMap<>();

        for (int num : nums)
            num2freq.merge(num, 1, Integer::sum);
        for (int f : num2freq.values())
            freq2cnt.merge(f, 1, Integer::sum);

        for (int i = nums.length - 1; i >= 0; i--) {
            Iterator<Map.Entry<Integer, Integer>> it = freq2cnt.entrySet().iterator();
            if (freq2cnt.size() == 2) {
                Map.Entry<Integer, Integer> nxt = it.next();
                int firstF = nxt.getKey(), firstC = nxt.getValue();
                nxt = it.next();
                int secondF = nxt.getKey(), secondC = nxt.getValue();

                if (firstF > secondF) {
                    int tempF = firstF;
                    int tempC = firstC;
                    firstF = secondF;
                    secondF = tempF;
                    firstC = secondC;
                    secondC = tempC;
                }
                if (secondF - firstF == 1 && secondC == 1)
                    return i + 1;
                if (firstF == 1 && firstC == 1)
                    return i + 1;

            } else if (freq2cnt.size() == 1) {
                Map.Entry<Integer, Integer> nxt = it.next();
                int f = nxt.getKey(), c = nxt.getValue();
                if (f == 1 || c == 1)
                    return i + 1;
            }
            int x = nums[i], f = num2freq.get(x);
            num2freq.put(x, f - 1);
            if (num2freq.get(x) == 0)
                num2freq.remove(x);
            freq2cnt.merge(f, -1, Integer::sum);
            if (freq2cnt.get(f) == 0)
                freq2cnt.remove(f);
            if (f - 1 > 0)
                freq2cnt.merge(f - 1, 1, Integer::sum);
        }

        return 2; // 最小不会小于2
    }
}
/*
 * freq type >= 3, not ok
 * freq type == 2,
 *   freq type是2，并且两种freq的差为1，并且最大的freq只有一种元素
 *   x x x y y y z z z z
 *   freq type是2，并且较小的freq为1，并且较小freq只有一种元素
 *   x x x y y y a
 *
 * freq type == 1
 *   所有元素的freq都为1 ok
 *   这个freq只包含一种元素 ok
 *
 *
 * */
