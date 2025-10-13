package medium;

// 1318. Minimum Flips to Make a OR b Equal to c

public class Solution1318 {
    public int minFlips(int a, int b, int c) {
        int x = Integer.bitCount((a | b) ^ c);  // 找到需要翻转的bit有多少个
        int y = Integer.bitCount(~c & a & b);   // 如果需要翻转的位置在c中是0, 但是a,b中是1, 这样的位置需要翻转两次
        return x + y;
    }
}
