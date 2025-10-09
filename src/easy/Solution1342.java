package easy;

// 1342. Number of Steps to Reduce a Number to Zero

public class Solution1342 {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        int x = (Integer.highestOneBit(num) << 1) - 1;
        int numOfOnes = Integer.bitCount(num);
        int numOfZeros = Integer.bitCount(x ^ num);
        return numOfOnes * 2 + numOfZeros - 1;
    }
}
