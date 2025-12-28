package easy;

// 605. Can Place Flowers

public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;
            boolean l = false, r = false;
            if (i > 0) {
                l = flowerbed[i - 1] == 0;
            }
            if (i < flowerbed.length - 1) {
                r = flowerbed[i + 1] == 0;
            }

            if (flowerbed.length - 1 == 0 && flowerbed[0] == 0
                    || i == 0 && r
                    || i == flowerbed.length - 1 && l
                    || l && r) {
                n--;
                flowerbed[i] = 1;
            }
            if (n == 0)
                return true;
        }
        return false;
    }
}
