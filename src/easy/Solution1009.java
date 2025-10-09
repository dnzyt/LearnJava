package easy;

// 1009. Complement of Base 10 Integer

public class Solution1009 {
    public int bitwiseComplement(int n) {
        if (n == 0)
            return 1;
        return ((Integer.highestOneBit(n) << 1) - 1) ^ n;
    }
}
