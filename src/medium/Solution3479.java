package medium;

// 3479. Fruits Into Baskets III

import java.util.*;

public class Solution3479 {

    private int[] mn;
    private Map<Integer, Deque<Integer>> busketPositions;
    private Map<Integer, Integer> numToIdx;

    private void build(int o, int l, int r) {
        if (l == r) {
            if (busketPositions.containsKey(l))
                mn[o] = busketPositions.get(l).poll();
            return;
        }
        int mid = (l + r) >>> 1;
        build(o * 2, l, mid);
        build(o * 2 + 1, mid + 1, r);
        mn[o] = Math.min(mn[o * 2], mn[o * 2 + 1]);
    }

    private void update(int o, int l, int r, int idx, int val) {
        if (l == r) {
            mn[o] = val;
            return;
        }
        int mid = (l + r) >>> 1;
        if (idx <= mid)
            update(o * 2, l, mid, idx, val);
        else
            update(o * 2 + 1, mid + 1, r, idx, val);
        mn[o] = Math.min(mn[o * 2], mn[o * 2 + 1]);
    }

    private int query(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            return mn[o];
        }
        int mid = (l + r) >>> 1;
        int res = Integer.MAX_VALUE;
        if (L <= mid)
            res = Math.min(res, query(o * 2, l, mid, L, R));
        if (R > mid)
            res = Math.min(res, query(o * 2 + 1, mid + 1, r, L, R));
        return res;
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        busketPositions = new HashMap<>();
        Set<Integer> bAndF = new HashSet<>();
        for (int i = 0; i < fruits.length; i++) {
            bAndF.add(fruits[i]);
        }
        for (int i = 0; i < baskets.length; i++) {
            bAndF.add(baskets[i]);
        }

        List<Integer> bs = new ArrayList<>(bAndF);
        Collections.sort(bs);
        numToIdx = new HashMap<>();
        for (int i = 0; i < baskets.length; i++) {
            int idx = getIdx(baskets[i], bs);
            if (!busketPositions.containsKey(idx))
                busketPositions.put(idx, new ArrayDeque<>());
            busketPositions.get(idx).offer(i);
        }
        int sz = bs.size();
        mn = new int[sz * 4];
        Arrays.fill(mn, Integer.MAX_VALUE);
        build(1, 0, sz - 1);

        int ans = 0;
        for (int f : fruits) {
            int idx = getIdx(f, bs);
            int b = query(1, 0, sz - 1, idx, sz - 1);
            if (b == Integer.MAX_VALUE) {
                ans++;
            } else {
                idx = getIdx(baskets[b], bs);
                if (busketPositions.get(idx).size() == 0) {
                    update(1, 0, sz - 1, idx, Integer.MAX_VALUE);
                } else {
                    update(1, 0, sz - 1, idx, busketPositions.get(idx).poll());
                }
            }
        }
        return ans;
    }

    private int getIdx(int num, List<Integer> bs) {
        if (!numToIdx.containsKey(num)) {
            numToIdx.put(num, Collections.binarySearch(bs, num));
        }
        return numToIdx.get(num);
    }
}
