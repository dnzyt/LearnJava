package easy;

// 1486. XOR Operation in an Array

// O(1) 的解法还是很难想的
// https://leetcode.cn/problems/xor-operation-in-an-array/solutions/2793723/o1-gong-shi-tui-dao-pythonjavaccgojsrust-le23/

public class Solution1486 {
    public int xorOperation(int n, int start) {
        int a = start / 2;
        int b = n & start & 1;
        return (xorN(a + n - 1) ^ xorN(a - 1)) * 2 + b;
    }
    
    private int xorN(int n) {
        return switch (n % 4) {
            case 0 -> n;
            case 1 -> 1;
            case 2 -> n + 1;
            default -> 0;
        };
    }
}
