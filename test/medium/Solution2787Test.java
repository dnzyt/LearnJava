package medium;

import easy.Solution434;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2787Test {

    private static Solution2787 solution;

    @BeforeAll
    public static void setup() {
        solution = new Solution2787();
    }

    @Test
    void numberOfWays() {
        solution.numberOfWays(64, 3);
    }
}