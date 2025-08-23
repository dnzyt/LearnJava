package medium;

// 167. Two Sum II - Input Array Is Sorted

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int s = numbers[left] + numbers[right];
            if (s == target) {
                return new int[] {left + 1, right + 1};
            }
            if (s < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[2];
    }
}
