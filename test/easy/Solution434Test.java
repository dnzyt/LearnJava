package easy;

import medium.Solution1488;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution434Test {
    private static Solution434 solution;

    @BeforeAll
    public static void setup() {
        solution = new Solution434();
    }


    @Test
    void countSegments() {
        solution.countSegments("Hello, my name is John");
    }
}