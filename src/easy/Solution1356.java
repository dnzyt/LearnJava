package easy;

// 1356. Sort Integers by The Number of 1 Bits

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution1356 {
    public int[] sortByBits(int[] arr) {
        Integer[] t = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(t, (a, b) -> {
            int x = Integer.bitCount(a);
            int y = Integer.bitCount(b);
            return x == y ? a - b : x - y;
        });
        return Arrays.stream(t).mapToInt(Integer::intValue).toArray();
    }
}
