package medium;

import hard.Solution3624;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2039Test {

    private static Solution2039 solution;

    @BeforeAll
    public static void setup() {
        solution = new Solution2039();
    }

    @Test
    void networkBecomesIdle() {
        int[][] edges = {{0, 1}, {1, 2}};
        int[] patience = {0, 2, 1};

        int ans = solution.networkBecomesIdle(edges, patience);
        assertEquals(ans, 8);
    }
}