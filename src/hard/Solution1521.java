package hard;

// 1521. Find a Value of a Mysterious Function Closest to Target

public class Solution1521 {
    public int closestToTarget(int[] arr, int target) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, Math.abs(arr[j] - target));
            for (int i = j - 1; i >= 0; i--) {
                if ((arr[i] & arr[j]) == arr[i]) break;
                arr[i] &= arr[j];
                ans = Math.min(ans, Math.abs(arr[i] - target));
            }
        }
        return ans;
    }
}
