package hard;

// 1835. Find XOR Sum of All Pairs Bitwise AND

public class Solution1835 {
    // (a&b)^(a&c) = a&(b^c)
    public int getXORSum(int[] arr1, int[] arr2) {
        int res1 = 0, res2 = 0;
        for (int num : arr1)
            res1 ^= num;
        for (int num : arr2)
            res2 ^= num;
        return res1 & res2;
    }
}
