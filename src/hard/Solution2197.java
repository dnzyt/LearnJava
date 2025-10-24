package hard;

// 2197. Replace Non-Coprime Numbers in Array

import java.util.ArrayList;
import java.util.List;

public class Solution2197 {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> st = new ArrayList<>();
        for (int num : nums) {
            while (!st.isEmpty() && gcd(num, st.get(st.size() - 1)) > 1) {
                num = lcm(num, st.remove(st.size() - 1));
            }
            st.add(num);
        }
        return st;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
