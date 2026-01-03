package easy;

// 1013. Partition Array Into Three Parts With Equal Sum

import java.util.Arrays;

public class Solution1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int n = arr.length;
        if (sum % 3 != 0)
            return false;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++)
            presum[i + 1] = presum[i] + arr[i];

        int i = 1;
        while (i <= n) {
            if (presum[i] == sum / 3)
                break;
            i++;
        }
        int j = n - 1;
        while (j >= 0) {
            if (presum[n] - presum[j] == sum / 3)
                break;
            j--;
        }
        return i < j;
    }
}
