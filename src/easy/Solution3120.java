package easy;

// 3120. Count the Number of Special Characters I

public class Solution3120 {
    public int numberOfSpecialChars(String word) {
        int[] mask = new int[2];
        for (char ch : word.toCharArray()) {
            // 大写字母的ascii值第六位为0
            // 小写字母的ascii值第六位为1
            // 它们的ascii值右5位都是相同的
            mask[(ch >> 5) & 1] |= (1 << (ch & 31));
        }
        return Integer.bitCount(mask[0] & mask[1]);
    }
}
