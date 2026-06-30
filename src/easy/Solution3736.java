package easy;

// 3736. Minimum Moves to Equal Array Elements III

public class Solution3736 {
    public int minMoves(int[] nums) {
        int mx = 0, sum = 0, n = nums.length;
        for (int num : nums) {
            mx = Math.max(mx, num);
            sum += num;
        }
        return mx * n - sum;
    }
}
