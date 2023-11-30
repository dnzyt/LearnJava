package medium;

// 46. Permutations

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(List.of(nums[0]));
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            IntStream s1 = Arrays.stream(nums, 0, i);
            IntStream s2 = Arrays.stream(nums, i + 1, nums.length);
            int[] temp = IntStream.concat(s1, s2).toArray();
            for (List<Integer> sub : permute(temp)) {
                List<Integer> curr = new ArrayList<>();
                curr.add(nums[i]);
                curr.addAll(sub);
                res.add(curr);
            }
        }
        return res;

    }


}
