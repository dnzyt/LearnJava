package easy;

import medium.Solution1488;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1488Test {
    private static Solution1488 solution1488;

    @BeforeAll
    public static void setup() {
        solution1488 = new Solution1488();
    }

    @Test
    void avoidFlood() {
        int[] arr = {1, 2, 0, 0, 2, 1};
        int[] res = solution1488.avoidFlood(arr);
        assertArrayEquals(res, new int[]{-1, -1, 2, 1, -1, -1});
    }
}