package util;

import java.util.Arrays;

public class PrimeSeq {
    public static boolean[] primes(int n) {
        boolean[] s = new boolean[n + 1];
        Arrays.fill(s, true);
        s[0] = false;
        s[1] = false;
        for (int i = 2; i <= n; i++) {
            if (s[i]) {
                for (int j = i * i; j > 0 && j <= n; j += i) // j有可能溢出
                    s[j] = false;
            }
        }
        return s;
    }
}
