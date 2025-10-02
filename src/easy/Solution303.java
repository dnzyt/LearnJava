package easy;

// 303. Range Sum Query - Immutable

public class Solution303 {
    class NumArray {
        private int[] s;

        public NumArray(int[] nums) {
            s = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++)
                s[i + 1] = s[i] + nums[i];
        }

        public int sumRange(int left, int right) {
            return s[right + 1] - s[left];
        }
    }
}


