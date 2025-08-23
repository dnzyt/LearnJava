package medium;

// 275. H-Index II

public class Solution275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        // 对解空间进行二分，而不是对citaitions数组二分
        // 解空间在 0 ~ n
        // 0肯定是合法的，所以在 1 ~ n 之间找
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (citations[n - mid] >= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
