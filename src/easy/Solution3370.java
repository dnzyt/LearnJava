package easy;

// 3370. Smallest Number With All Set Bits

public class Solution3370 {
    public int smallestNumber(int n) {
        int count = 32 - Integer.numberOfLeadingZeros(n);
        return (1 << count) - 1;
    }

    public int smallestNumber2(int n) {
        return (Integer.highestOneBit(n) << 1) - 1;
    }
}
