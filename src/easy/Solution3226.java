package easy;

// 3226. Number of Bit Changes to Make Two Integers Equal

public class Solution3226 {
    // 其实就是判断k是不是n的子集
    public int minChanges(int n, int k) {
        if ((k & n) == k)
            return Integer.bitCount(n ^ k);
        return -1;
    }
}
