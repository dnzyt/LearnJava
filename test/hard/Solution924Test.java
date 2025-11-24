package hard;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution924Test {

    private static Solution924 solution;

    @BeforeAll
    public static void setup() {
        solution = new Solution924();
    }

    @Test
    void minMalwareSpread() {
        int[] initial = new int[]{3, 1};
        int[][] graph = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };
        solution.minMalwareSpread(graph, initial);
    }
}