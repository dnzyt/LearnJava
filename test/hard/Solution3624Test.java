package hard;

import medium.Solution1488;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution3624Test {
    private static Solution3624 solution;

    @BeforeAll
    public static void setup() {
        solution = new Solution3624();
    }

    @Test
    void popcountDepth() {
        long[] nums = new long[]{2, 4};
        long[][] arr = {
                {1L, 0L, 1L, 1L},
                {2L, 1L, 1L},
                {1L, 0L, 1L, 0L}
        };
        int[] res = solution.popcountDepth(nums, arr);
        assertArrayEquals(new int[]{2, 1}, res);
    }

    @Test
    void popcountDepth2() {
        long[] nums = new long[]{3, 5, 6};
        long[][] arr = {
                {1, 0, 2, 2},
                {2, 1, 4},
                {1, 1, 2, 1},
                {1, 0, 1, 0}
        };
        int[] res = solution.popcountDepth(nums, arr);
        assertArrayEquals(new int[]{3, 1, 0}, res);
    }

    @Test
    void popcountDepth3() {
        long[] nums = new long[]{1, 2};
        long[][] arr = {
                {1, 0, 1, 1},
                {2, 0, 3},
                {1, 0, 0, 1},
                {1, 0, 0, 2}
        };
        int[] res = solution.popcountDepth(nums, arr);
        assertArrayEquals(new int[]{1, 0, 1}, res);
    }

    @Test
    void testPopcountDepth() {
        assertEquals(2, solution.countDepth(6));
        assertEquals(2, solution.countDepth(5));
        assertEquals(2, solution.countDepth(3));
        assertEquals(1, solution.countDepth(2));
    }
}