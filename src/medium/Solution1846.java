package medium;

// 1846. Maximum Element After Decreasing and Rearranging

import java.util.Arrays;

public class Solution1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] != 1)
            arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                arr[i] = arr[i - 1] + 1;
            else if (arr[i] < arr[i - 1])
                return arr[i];
        }
        return arr[arr.length - 1];
    }
}
