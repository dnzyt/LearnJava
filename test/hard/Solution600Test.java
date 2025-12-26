package hard;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution600Test {
    private static Solution600 solution;

    @BeforeAll
    public static void setup() {
        solution = new Solution600();
    }

    @Test
    void findIntegers() {
        solution.findIntegers(5);
    }
}