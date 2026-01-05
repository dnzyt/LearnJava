package medium;

import easy.Solution434;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution3800Test {

    private static Solution3800 solution;

    @BeforeAll
    public static void setup() {
        solution = new Solution3800();
    }

    @Test
    void minimumCost() {
        solution.minimumCost("001", "110", 2, 100, 100);
    }
}