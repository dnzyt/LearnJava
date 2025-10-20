package easy;

// 2558. Take Gifts From the Richest Pile

public class Solution2558 {
    public long pickGifts(int[] gifts, int k) {
        heapify(gifts);
        while (k-- > 0 && gifts[0] > 1) {
            gifts[0] = (int) Math.sqrt(gifts[0]);
            sink(gifts, 0);
        }
        long ans = 0;
        for (int x : gifts)
            ans += x;
        return ans;
    }

    private void heapify(int[] h) {
        for (int i = h.length / 2 - 1; i >= 0; i--) {
            sink(h, i);
        }
    }

    private void sink(int[] h, int i) {
        while (i * 2 + 1 < h.length) {
            int j = i * 2 + 1;
            if (j + 1 < h.length && h[j] < h[j + 1]) {
                j++;
            }
            if (h[i] > h[j])
                break;
            swap(h, i, j);
            i = j;
        }
    }

    private void swap(int[] h, int i, int j) {
        int temp = h[i];
        h[i] = h[j];
        h[j] = temp;
    }
}
