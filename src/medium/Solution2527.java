package medium;

// 2527. Find Xor-Beauty of Array

public class Solution2527 {
    // 只有i=j=k的时候才对最终结果有贡献，其他的情况异或时都被抵消了
    public int xorBeauty(int[] nums) {
        int ans = 0;
        for (int num : nums)
            ans ^= num;
        return ans;
    }
}
