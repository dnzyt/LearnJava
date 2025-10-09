package easy;

// 476. Number Complement

public class Solution476 {
    public int findComplement(int num) {
        return ((Integer.highestOneBit(num) << 1) - 1) ^ num;

    }
}
