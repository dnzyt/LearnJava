package lcr;

// LCR 170. 交易逆序对的总数

import java.util.*;

public class Solution170 {
    // 归并解法
    public int reversePairs(int[] record) {
        return dfs(record, 0, record.length);
    }


    private int dfs(int[] record, int start, int end) {
        if (start + 1 == end)
            return 0;
        int mid = (start + end) >>> 1;
        int res = dfs(record, start, mid) + dfs(record, mid, end);
        for (int i = start; i < mid; i++) {
            res += lowerBound(record, mid, end, record[i]);
        }
        Arrays.sort(record, start, end);
        return res;
    }

    private int lowerBound(int[] arr, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }


    private int[] tree;

    public int reversePairs2(int[] record) {
        SortedSet<Integer> s = new TreeSet<>();
        for (int num : record)
            s.add(num);
        List<Integer> arr = new ArrayList<>(s);
        int n = s.size();
        tree = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < record.length; i++) {
            int num = record[i];
            int idx = Collections.binarySearch(arr, num) + 1;
            ans += query(arr.size()) - query(idx);
            add(idx, 1);
        }
        return ans;
    }

    private void add(int i, int delta) {
        while (i < tree.length) {
            tree[i] += delta;
            i += lowbit(i);
        }
    }

    private int query(int i) {
        int ans = 0;
        while (i > 0) {
            ans += tree[i];
            i -= lowbit(i);
        }
        return ans;
    }

    private int lowbit(int x) {
        return x & -x;
    }
}
