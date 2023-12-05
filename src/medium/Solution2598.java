package medium;

// 2598. Smallest Missing Non-negative Integer After Operations

public class Solution2598 {

    public int findSmallestInteger(int[] nums, int value) {
        int[] counter = new int[value];
        for (int num : nums) {
            // java取模会出现负数，这一点和python不一样
            counter[(num%value + value)%value] ++;
        }
        int minFreq = Integer.MAX_VALUE;
        int r = 0;
        for (int i = 0; i < value; i++) {
            if (counter[i] < minFreq) {
                minFreq = counter[i];
                r = i;
            }
        }
        return value * minFreq + r;
    }
}
