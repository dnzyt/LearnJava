package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearSieveTest {

    @Test
    void sieve() {
        boolean[] isPrime = LinearSieve.sieve(100);
        for (int i = 2; i <= 100; i++) {
            System.out.println(i + " " + isPrime[i]);
        }
    }

    @Test
    void mobiuz() {
        int[] mobiuz = LinearSieve.mobiuz(10);
        for (int i = 2; i <= 10; i++) {
            System.out.println(i + " -> " + mobiuz[i]);
        }
    }
}