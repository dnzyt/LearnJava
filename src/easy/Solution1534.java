package easy;

// 1534. Count Good Triplets

public class Solution1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int mx = 0;
        for (int x : arr)
            mx = Math.max(mx, x);
        int[] s = new int[mx + 2];
        int ans = 0;
        for (int j = 0; j < arr.length; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                if (Math.abs(arr[k] - arr[j]) > b) continue;
                int l = Math.max(0, Math.max(arr[j] - a, arr[k] - c));
                int r = Math.min(mx, Math.min(arr[j] + a, arr[k] + c));
                ans += Math.max(0, s[r + 1] - s[l]);
            }
            for (int x = arr[j] + 1; x < mx + 2; x++)
                s[x]++;
        }
        return ans;
    }
}
