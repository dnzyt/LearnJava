package hard;

// 3307. Find the K-th Character in String Game II

public class Solution3307 {
    public char kthCharacter(long k, int[] operations) {
        int cnt = 0;
        long sz = 1l;
        while (sz < k) {
            cnt++;
            sz *= 2;
        }

        int move = 0;
        for (int i = cnt - 1; i >= 0; i--) {

            sz /= 2;
            if (k > sz) {
                k -= sz;
                if (operations[i] == 1)
                    move++;
            }

        }
        return (char) ('a' + move % 26);
    }
}
