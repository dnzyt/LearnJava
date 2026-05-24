package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GCDTest {

    @Test
    void exGcd() {
        int[] ans = GCD.exGcd(20, 135);
        System.out.println("GCD: " + ans[0]);
        ans = GCD.exGcd(3, 11);
        System.out.println("Inverse: " + ans[1]);
    }
}