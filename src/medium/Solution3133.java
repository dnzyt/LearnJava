package medium;

// 3133. Minimum Array End

public class Solution3133 {
    public long minEnd(int n, int x) {
        n--;
        int k = 0;
        long ans = x;
        while (n > 0) {
            if ((ans & (1L << k)) == 0) {
                ans |= ((n & 1L) << k);
                n >>= 1;
            }
            k++;
        }
        return ans;
    }

    // 优化
    // 用lowbit在x中直接定位可以用的0
    public long minEnd2(int n, int x) {
        n--;
        int j = 0;
        long t = ~x;
        long ans = x;
        while (n >> j > 0) {
            long lowbit = t & -t;
            int bit = (n >> j) & 1;
            ans |= bit * lowbit; //bit为0的话，那么什么都不变，如果为1那么ans对应的0变1
            j++;
            t ^= lowbit;
        }
        return ans;
    }
}
