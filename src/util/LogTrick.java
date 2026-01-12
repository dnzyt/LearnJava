package util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class LogTrick {
    public List<int[]> logTrick(int[] nums, BiFunction<Integer, Integer, Integer> op) {
        int n = nums.length;
        List<int[]> orLeftRight = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int[] p : orLeftRight)
                p[0] = op.apply(p[0], nums[i]);
            orLeftRight.add(new int[]{nums[i], i, i + 1});
            int idx = 0;
            for (int j = 1; j < orLeftRight.size(); j++) {
                if (orLeftRight.get(j)[0] != orLeftRight.get(idx)[0]) {
                    idx++;
                    orLeftRight.set(idx, orLeftRight.get(j));
                } else {
                    // 右端点扩展为当前j的右端点
                    orLeftRight.get(idx)[2] = orLeftRight.get(j)[2];
                }
            }
            orLeftRight.subList(idx + 1, orLeftRight.size()).clear();
        }
        return orLeftRight;
    }
}
