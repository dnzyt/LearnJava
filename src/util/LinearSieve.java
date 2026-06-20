package util;

import java.util.ArrayList;
import java.util.List;

public class LinearSieve {

    // 判断1～n哪些是质数
    public static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }

            for (int p : primes) {
                if (i * p > n)
                    break;
                isPrime[i * p] = false;
                if (i % p == 0)
                    break;
            }
        }
        return isPrime;
    }

    public static int[] mobiuz(int n) {
        int[] mu = new int[n + 1];
        mu[1] = 1;
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++)
            isPrime[i] = true;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
                mu[i] = -1;
            }
            for (int p : primes) {
                if (i * p > n)
                    break;
                isPrime[i * p] = false;
                if (i % p == 0) {
                    mu[i * p] = 0;
                    break;
                } else {
                    mu[i * p] = -mu[i];
                }
            }
        }
        return mu;
    }
}
