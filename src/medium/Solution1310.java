package medium;

// 1310. XOR Queries of a Subarray

public class Solution1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] ^ arr[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            ans[i] = presum[right + 1] ^ presum[left];
        }
        return ans;
    }
}
