package easy;

// 3827. Count Monobit Integers

public class Solution3827 {
    public int countMonobit(int n) {
        int l = 32 - Integer.numberOfLeadingZeros(n);
        return (1 << l) - 1 == n ? l + 1 : l;
    }
}
