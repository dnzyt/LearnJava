package easy;

// 860. Lemonade Change

public class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int x : bills) {
            switch (x) {
                case 5:
                    five++;
                    break;
                case 10:
                    if (five > 0) {
                        five--;
                        ten++;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                    } else if (five > 2) {
                        five -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
