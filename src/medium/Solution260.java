package medium;

// 260. Single Number III

public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums)
            bitmask ^= num;
        int leftmostOne = bitmask & (-bitmask);
        int a = 0;
        for (int num : nums) {
            if ((num & leftmostOne) != 0)
                a ^= num;
        }
        return new int[] {a, bitmask ^ a};
    }
}
