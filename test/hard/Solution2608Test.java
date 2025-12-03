package hard;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2608Test {

    private static Solution2608 solution;

    @BeforeAll
    public static void setup() {
        solution = new Solution2608();
    }

    @Test
    void findShortestCycle() {
        int n = 7;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}, {4, 5}, {5, 6}, {6, 3}};
        int ans = solution.findShortestCycle(7, edges);
        assertEquals(ans, 3);
    }
}