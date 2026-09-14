package hard;

// 564. Find the Closest Palindrome

public class Solution564 {
    private long minDiff;
    private long ans;
    public String nearestPalindromic(String n) {
        minDiff = Long.MAX_VALUE;
        int m = n.length();
        long num = Long.parseLong(n);
        update((long) Math.pow(10, m) + 1, num);
        update((long) Math.pow(10, m - 1) - 1, num);
        long left = Long.parseLong(n.substring(0, (m + 1) / 2));
        for (long i = left - 1; i <= left + 1; i++) {
            long x = m % 2 == 0 ? i : i / 10;
            long pal = i;
            while (x > 0) {
                pal *= 10;
                pal += x % 10;
                x /= 10;
            }
            update(pal, num);
        }
        return String.valueOf(ans);
    }

    private void update(long pal, long num) {
        long diff = Math.abs(pal - num);
        if (diff > 0 && (diff < minDiff || diff == minDiff && pal < ans)) {
            ans = pal;
            minDiff = diff;
        }
    }
}
