package medium;

// 2429. Minimize XOR

public class Solution2429 {
    public int minimizeXor(int num1, int num2) {
        int a = Integer.bitCount(num1);
        int b = Integer.bitCount(num2);
        for (; a > b; a--) num1 &= (num1 - 1);  // 把最低位的0变成1 a & (a - 1)
        for (; a < b; b--) num1 |= (num1 + 1);  // 把最低位的1变成0 a | (a + 1)
        return num1;
    }
}
