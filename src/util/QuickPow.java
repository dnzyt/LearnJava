package util;

public class QuickPow {
    public int pow(int x, int y) {
        int res = 1;
        int curr = x;
        while (y > 0) {
            if ((y & 1) == 1)
                res = res * curr;
            curr *= curr;
            y >>= 1;
        }
        return res;
    }
}
