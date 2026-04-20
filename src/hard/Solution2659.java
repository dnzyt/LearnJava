package hard;

// 2659. Make Array Empty

import java.util.Arrays;
import java.util.Comparator;

public class Solution2659 {
    private record Pair(int num, int idx) {
    }

    // 操作分为两类：
    // 1. 删除操作，一共只执行n次，因为有n个数要删除
    // 2. 移动操作
    // 所以只要看需要多少移动操作，再加上n就是答案
    // 每次从头到尾遍历数组，肯定能删除最小值，关键看能不能顺带删除更多次小值和第三小，第四小...
    // 如果同一次遍历中次小值在最小值右边，说明可以顺带删除，在这个次小值上只有删除操作，不需要移动操作
    // 如果次小值在最小值左边，说明删除最小值后要绕一圈重新回到开头，这样才能在下一次遍历中删除这个次小值，这样
    // 为了删除这个次小值就产生了移动操作
    // 因为要绕回到开头，那么为了再下一次遍历中删除这个次小值，就产生了n-k个移动操作，k是已经删除的元素个数
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a.num));
        long ans = n;
        for (int k = 1; k < n; k++) {
            if (pairs[k].idx < pairs[k - 1].idx)
                ans += n - k;
        }
        return ans;
    }
}
