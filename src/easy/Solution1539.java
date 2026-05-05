package easy;

// 1539. Kth Missing Positive Number

public class Solution1539 {
    // 统计每一个元素前面有多少失踪的数字
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int[] miss = new int[n];
        for (int i = 0; i < n; i++)
            miss[i] = arr[i] - (i + 1); // 到arr[i]为止有多少失踪的数字
        // 找到第一个>=k的元素，那么最靠近arr[idx]的数字就是arr[idx]-1
        int idx = upperBound(miss, k);
        return idx + k;
    }

    private int upperBound(int[] arr, int target) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}
