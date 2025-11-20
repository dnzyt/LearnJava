package hard;

// 3072. Distribute Elements Into Two Arrays II

import util.FenwickTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution3702 {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] sorted = IntStream.of(nums).sorted().toArray();
        FenwickTree f1 = new FenwickTree(n);
        FenwickTree f2 = new FenwickTree(n);
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int idx1 = Arrays.binarySearch(sorted, nums[0]);
        int idx2 = Arrays.binarySearch(sorted, nums[1]);
        f1.update(idx1 + 1, 1);
        f2.update(idx2 + 1, 1);
        for (int i = 2; i < n; i++) {
            int idx = Arrays.binarySearch(sorted, nums[i]);
            int count1 = f1.query(n) - f1.query(idx + 1);
            int count2 = f2.query(n) - f2.query(idx + 1);
            if (count1 > count2) {
                arr1.add(nums[i]);
                f1.update(idx + 1, 1);
            } else if (count1 < count2) {
                arr2.add(nums[i]);
                f2.update(idx + 1, 1);
            } else {
                if (arr1.size() <= arr2.size()) {
                    arr1.add(nums[i]);
                    f1.update(idx + 1, 1);
                } else {
                    arr2.add(nums[i]);
                    f2.update(idx + 1, 1);
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < arr1.size(); i++)
            ans[i] = arr1.get(i);
        for (int i = 0; i < arr2.size(); i++)
            ans[i + arr1.size()] = arr2.get(i);
        return ans;
    }
}
