package easy;

// 1331. Rank Transform of an Array

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] c = arr.clone();
        Arrays.sort(c);
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for (int num : c) {
            if (map.containsKey(num))
                continue;
            map.put(num, idx++);
        }
        for (int i = 0; i < arr.length; i++)
            arr[i] = map.get(arr[i]);
        return arr;
    }
}
