package easy;

// 2917. Find the K-or of an Array

public class Solution2917 {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int r = 0;
            for (int num : nums) {
                r += (num >> i) & 1;
            }
            if (r >= k)
                ans |= (1 << i);
        }
        return ans;
    }
}
