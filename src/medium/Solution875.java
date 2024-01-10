package medium;

// 875. Koko Eating Bananas

public class Solution875 {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles)
            r = Math.max(r, pile);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (timeCost(piles, mid) <= h) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private long timeCost(int[] piles, int speed) {
        long res = 0;
        for (int pile : piles)
            res += (pile + speed - 1) / speed; // 上取整
        return res;
    }
}
