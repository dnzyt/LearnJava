package util;

import java.util.ArrayList;
import java.util.List;

public class Eratosthenes {

    public List<Integer> findPrimesUntil(int n) {
        int[] q = new int[n + 1];
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (q[i] == 1) continue;
            int j = i * 2;
            while (j <= n) {
                q[j] = 1;
                j += i;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (q[i] == 0)
                primes.add(i);
        }
        return primes;
    }
    public int[] numOfPrimes(int n) {
        int[] res = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (res[i] > 0) continue;
            res[i] = 1;
            int j = i * 2;
            while (j <= n) {
                res[j] += 1;
                j += i;
            }
        }
        return res;
    }
}
