package easy;

// 3769. Sort Integers by Binary Reflection

import java.util.Arrays;

public class Solution3769 {
    public int[] sortByReflection(int[] nums) {
        int n = nums.length;
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> {
            int revA = Integer.reverse(a) >>> Integer.numberOfLeadingZeros(a);
            int revB = Integer.reverse(b) >>> Integer.numberOfLeadingZeros(b);
            return revA != revB ? revA - revB : a - b;
        });

        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }
}
