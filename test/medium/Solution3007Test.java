package medium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution3007Test {
    private static Solution3007 solution;

    @BeforeAll
    public static void setup() {
        solution = new Solution3007();
    }


    @Test
    void findMaximumNumber() {
        long k = 282288420250713L;
        int x = 8;
        solution.findMaximumNumber(k, x);
    }
}