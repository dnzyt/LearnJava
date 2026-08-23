package medium;

// 1927. Sum Game

public class Solution1927 {
    public boolean sumGame(String num) {
        int[] left = calc(num.substring(0, num.length() / 2));
        int[] right = calc(num.substring(num.length() / 2));
        int lsum = left[0], lq = left[1];
        int rsum = right[0], rq = right[1];
        return (lq + rq) % 2 == 1 || rsum - lsum != (lq - rq) / 2 * 9;
    }

    private int[] calc(String s) {
        int sum = 0;
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '?')
                cnt++;
            else
                sum += c - '0';
        }
        return new int[]{sum, cnt};
    }
}
