package easy;

// 693. Binary Number with Alternating Bits

public class Solution693 {
    public boolean hasAlternatingBits(int n) {
        int l = 32 - Integer.numberOfLeadingZeros(n);
        int num = (1 << l) - 1;
        for (int i = l - 2; i >= 0; i -= 2) {
            num ^= (1 << i);
        }
        return n == num;
    }
}
