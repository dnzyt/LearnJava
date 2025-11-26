package hard;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1591Test {

    private static Solution1591 solution;

    @BeforeAll
    public static void setup() {
        solution = new Solution1591();
    }

    @Test
    void isPrintable() {
        int[][] graph = {
                {1, 1, 1, 1},
                {1, 1, 3, 3},
                {1, 1, 3, 4},
                {5, 5, 1, 4}
        };
        solution.isPrintable(graph);
    }
}