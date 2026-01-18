package medium;

// 477. Total Hamming Distance

public class Solution477 {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int s1 = 0;
            for (int num : nums) {
                if (((num >> i) & 1) > 0)
                    s1++;
            }
            res += (nums.length - s1) * s1;
        }
        return res;
    }
}
