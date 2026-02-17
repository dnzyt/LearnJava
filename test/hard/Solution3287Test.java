package hard;

import easy.Solution434;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution3287Test {

    private static Solution3287 solution;

    @BeforeAll
    public static void setup() {
        solution = new Solution3287();
    }


    @Test
    void maxValue() {
        int[] nums = {4, 2, 5, 6, 7};
        int k = 2;

        solution.maxValue(nums, k);
    }
}