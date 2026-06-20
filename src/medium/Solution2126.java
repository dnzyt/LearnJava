package medium;

// 2126. Destroying Asteroids

import java.util.Arrays;

public class Solution2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int a : asteroids) {
            if (mass < a)
                return false;
            mass += a;
        }
        return true;
    }
}
