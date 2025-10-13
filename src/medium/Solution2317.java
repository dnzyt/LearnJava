package medium;

// 2317. Maximum XOR After Operations

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution2317 {
    public int maximumXOR(int[] nums) {
        return IntStream.of(nums).reduce(0, (a, b) -> a | b);
    }
}
