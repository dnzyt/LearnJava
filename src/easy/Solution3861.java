package easy;

// 3861. Minimum Capacity Box

public class Solution3861 {
    public int minimumIndex(int[] capacity, int itemSize) {
        int ans = -1;
        int cap = Integer.MAX_VALUE;
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] >= itemSize && capacity[i] < cap) {
                ans = i;
                cap = capacity[i];
            }
        }
        return ans;
    }
}
