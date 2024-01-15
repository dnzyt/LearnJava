package easy;

// 922. Sort Array By Parity II

public class Solution922 {

    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 1;
        while (even < nums.length && odd < nums.length) {
            if (nums[nums.length - 1] % 2 == 1) {
                int temp = nums[odd];
                nums[odd] = nums[nums.length - 1];
                nums[nums.length - 1] = temp;
                odd += 2;
            } else {
                int temp = nums[even];
                nums[even] = nums[nums.length - 1];
                nums[nums.length - 1] = temp;
                even += 2;
            }
        }
        return nums;
    }

}
