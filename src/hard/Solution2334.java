package hard;

// 2334. Subarray With Elements Greater Than Varying Threshold

import java.util.*;

// 2334. Subarray With Elements Greater Than Varying Threshold

public class Solution2334 {

    public int validSubarraySize(int[] nums, int threshold) {
        // 在最后加一个0是为了能把单调栈清空
        nums = Arrays.copyOf(nums, nums.length + 1);
        nums[nums.length - 1] = 0;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }

        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 这里和栈的最后一个元素比较的时候不用>=是因为虽然当前元素左边界可能不准确，
            // 但是和这个元素相等的元素第一次出现时，它左边是准确的
            // 每个元素的右边界一定是准确的
            // 子数组最小值确定的之后，越长越有可能成立
            // 这样具有相同值的元素只需要检查第一次出现的时候，而任何第一次出现的元素左右边界都是准确的
            // 所以这里只用大于号
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                int j = st.pop();
                right[j] = i;

                int sz = right[j] - left[j] - 1;
                if (nums[j] > threshold / sz)
                    return sz;
            }
            if (!st.isEmpty())
                left[i] = st.peek();
            st.push(i);
        }
        return -1;
    }

    // 并查集解法
    private int[] sz;
    private int[] pa;

    public int validSubarraySize2(int[] nums, int threshold) {
        int n = nums.length;
        sz = new int[n + 1];
        pa = new int[n + 1];
        for (int i = 0; i <= n; i++)
            pa[i] = i;
        List<int[]> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.add(new int[]{nums[i], i});
        }
        Collections.sort(s, (a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            int num = s.get(i)[0];
            int idx = s.get(i)[1];
            int p = find(idx + 1);
            pa[idx] = p;
            sz[p] += sz[idx] + 1;
            if (num > threshold / sz[p])
                return sz[p];
        }
        return -1;


    }

    private int find(int x) {
        if (pa[x] != x)
            pa[x] = find(pa[x]);
        return pa[x];
    }

}
