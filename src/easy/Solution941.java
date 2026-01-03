package easy;

// 941. Valid Mountain Array

public class Solution941 {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0;
        while (left + 1 < n && arr[left] < arr[left + 1])
            left++;
        int right = n - 1;
        while (right - 1 >= 0 && arr[right] < arr[right - 1])
            right--;
        return left > 0 && right < n - 1 && left == right;
    }
}
