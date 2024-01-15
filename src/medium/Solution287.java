package medium;

// 287. Find the Duplicate Number

public class Solution287 {
    // 链表，找环的入口
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
