package medium;

// 907. Sum of Subarray Minimums

import java.util.Arrays;
import java.util.Stack;

public class Solution907 {

    public int sumSubarrayMins(int[] arr) {
        long M = 1000000007;
        Stack<Integer> stack = new Stack<>();
        int[] right = new int[arr.length];  // <
        Arrays.fill(right, arr.length);
        int[] left = new int[arr.length];   // <=
        Arrays.fill(left, -1);
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && arr[stack.peek()] > arr[i]) {
                right[stack.pop()] = i;
            }
            stack.add(i);
        }
        stack.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
                left[stack.pop()] = i;
            }
            stack.add(i);
        }
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = (res + (long) (i - left[i]) * (right[i] - i) * arr[i]) % M;
        }
        return (int) res;
    }
}
