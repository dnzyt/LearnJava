package hard;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1449Test {

    private static Solution1449 solution;

    @BeforeAll
    public static void setup() {
        solution = new Solution1449();
    }

    @Test
    void largestNumber() {
        solution.largestNumber(new int[]{1, 1, 1, 1, 1, 1, 1, 3, 2}, 10);
    }
}