package hard;

// 41. First Missing Positive

public class Solution41 {

    // index sorting 解法
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (!(nums[i] == i + 1 || nums[i] - 1 < 0 || nums[i] - 1 >= nums.length || nums[i] == nums[nums[i] - 1]))
                swap(nums, i, nums[i] - 1);
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return nums.length + 1;
    }


    // 双指针解法
    public int firstMissingPositive1(int[] nums) {
        // 排序之后，正常情况下l位置应该放的数应为l+1
        int l = 0; // l下一个要检查的索引位置，l左边已经排好序了
        int r = nums.length; // r表示垃圾区的起始位置
        while (l < r) {
            // 此种情况说明l位置上的数时l+1，已经是正确的数了
            if (nums[l] == l + 1) {
                l += 1;
                continue;
            }
            // 这些情况说明目前l位置上的数已经是垃圾了，不可能形成idx上是idx+1的情况
            // nums[l] < l + 1：说名nums[l]需要放在l的左边，但是左边已经排好序了，没有nums[l]的位置
            // nums[l] > r：说明nums[l]需要放在r或者r的右边，r已经是垃圾区了，超出了可能排序的区间
            // nums[l] == nums[nums[l] - 1]：说明nums[l]-1这个位置已经是正确的数nums[l]了，没必要换，所以当前l上的nums[l]是多余的
            if (nums[l] < l + 1 || nums[l] > r || nums[l] == nums[nums[l] - 1]) {
                r -= 1;
                swap(nums, l, r);
                continue;
            }
            swap(nums, l, nums[l] - 1);

        }
        return l + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}
