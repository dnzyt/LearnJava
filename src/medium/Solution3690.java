package medium;

// 3690. Split and Merge Array Transformation

import java.util.*;

public class Solution3690 {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        List<Integer> nums1List = toList(nums1);
        List<Integer> nums2List = toList(nums2);
        Set<List<Integer>> visited = new HashSet<>();
        Queue<List<Integer>> q = new ArrayDeque<>();
        visited.add(nums1List);
        q.offer(nums1List);
        int ans = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            while (k-- > 0) {
                List<Integer> curr = q.poll();
                if (curr.equals(nums2List))
                    return ans;
                for (int l = 0; l < n; l++) {
                    for (int r = l + 1; r <= n; r++) {
                        List<Integer> sub = curr.subList(l, r);
                        List<Integer> currCopy = new ArrayList<>(curr);
                        currCopy.subList(l, r).clear();
                        for (int i = 0; i <= currCopy.size(); i++) {
                            List<Integer> c = new ArrayList<>(currCopy);
                            c.addAll(i, sub);
                            if (visited.add(c))
                                q.offer(c);
                        }
                    }
                }

            }
            ans++;
        }
        return ans;
    }

    private List<Integer> toList(int[] nums) {
        return Arrays.stream(nums).boxed().toList();
    }
}
