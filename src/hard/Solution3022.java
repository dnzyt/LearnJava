package hard;

// 3022. Minimize OR of Remaining Elements Using Operations

public class Solution3022 {
    public int minOrAfterOperations(int[] nums, int k) {
        int ans = 0;
        int mask = 0; // 0的位表示这个为不可能构造为0， 1的位表示这个位可以构造为1
        for (int i = 29; i >= 0; i--) {
            mask |= (1 << i);
            int cnt = 0;
            int andRes = -1;
            for (int num : nums) {
                andRes &= num & mask;
                if (andRes != 0) {
                    cnt++;
                } else {
                    andRes = -1;
                }
            }
            if (cnt > k) {
                mask ^= (1 << i);
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
