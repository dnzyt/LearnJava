package hard;

// 995. Minimum Number of K Consecutive Bit Flips

public class Solution995 {
    /*
     * 贪心部分的证明。
     * 结论1：最靠左的翻转的左边界一定是第一个0的位置。
     * 证明：反证，若不然，则最左侧的翻转的左边界要么是1，要么不是第一个0。如果是1的话，那么这个1会变为0且没有操作可以将它变回1。
     * 如果不是第一个0的话，那么第一个0也无法变为1。
     * 根据结论1，我们可以得知最靠左的翻转的位置。把翻转后的结果当作新的输入又可以知道下一次最靠左的翻转的位置，如此往复即可。
     * */
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if ((nums[i] + sum) % 2 == 1) continue;
            if (i + k > n) return -1;
            sum++;
            diff[i + k] -= 1;
            ans++;
        }
        return ans;
    }
}
