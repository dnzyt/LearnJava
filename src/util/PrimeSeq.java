package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSeq {
    // 求某一个数是否为质数
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

    // 求一个数的质因数出现次数
    // 1~n每个数的每个质因数出现次数
    public List<Integer>[] countPrimeFactors(int n) {
        List<Integer>[] ans = new List[n + 1];
        for (int i = 2; i <= n; i++) {
            List<Integer> t = new ArrayList<>();
            int x = i;
            int p = 2;
            while (p * p <= x) {
                int cnt = 0;
                while (x % p == 0) {
                    cnt++;
                    x /= p;
                }
                t.add(cnt);
                p++;
            }
            if (x > 1)
                t.add(1);
            ans[i] = t;
        }
        return ans;
    }

}
