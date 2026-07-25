package medium;

// 179. Largest Number

import java.util.Arrays;

public class Solution179 {
    public String largestNumber(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> {
            String s = String.valueOf(a);
            String t = String.valueOf(b);
            return (t + s).compareTo(s + t);
        });
        if (arr[0] == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        for (int num : arr)
            sb.append(num);
        return sb.toString();
    }
}
