package medium;

// 2997. Minimum Number of Operations to Make Array XOR Equal to K

public class Solution2997 {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        return Integer.bitCount(xor ^ k);
    }
}
