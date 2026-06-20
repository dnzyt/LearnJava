package easy;

// 3304. Find the K-th Character in String Game I

public class Solution3304 {
    public char kthCharacter(int k) {
        return (char) ('a' + (32 - Integer.bitCount(k - 1)));
    }
}
