package hard;

// 2818. Apply Operations to Maximize Score

import javafx.util.Pair;

import java.util.*;

/*
* 先算出nums每个元素有多少个质因数
* 然后用单调栈确定每个元素左边和右边最远能到哪里
*
*
* */

public class Solution2818 {
    final private long mod = 1000000007;
    public int maximumScore(List<Integer> nums, int k) {

        int maxx = Collections.max(nums);
        int[] primes = numOfPrimes(maxx);
        int[] scores = new int[nums.size()];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = primes[nums.get(i)];
        }

        int[] prevLargerOrEqual = new int[nums.size()];
        int[] nextLarger = new int[nums.size()];
        for (int i = 0; i < scores.length; i++) {
            prevLargerOrEqual[i] = -1;
            nextLarger[i] = scores.length;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < scores.length; i++) {
            while (!stack.empty() && scores[stack.peek()] < scores[i]) {
                int idx = stack.pop();
                nextLarger[idx] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = scores.length - 1; i >= 0; i--) {
            while (!stack.empty() && scores[stack.peek()] <= scores[i]) {
                int idx = stack.pop();
                prevLargerOrEqual[idx] = i;
            }
            stack.push(i);
        }

        List<Pair<Integer, Integer>> temp = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int t = (i - prevLargerOrEqual[i]) * (nextLarger[i] - i);
            Pair<Integer, Integer> p = new Pair<>(nums.get(i), t);
            temp.add(p);
        }
        temp.sort((a, b) -> b.getKey() - a.getKey());
        long res = 1;
        for (Pair<Integer, Integer> pair : temp) {
            int num = pair.getKey();
            int t = pair.getValue();
            if (k >= t) {
                res = res * pow(num, t) % mod;
                k -= t;
            } else {
                res = res * pow(num, k) % mod;
                k = 0;
            }
            if (k == 0)
                break;
        }
        return (int) res;

    }
    private long pow(long x, long y) {
        long res = 1;
        long curr = x;
        while (y > 0) {
            if ((y & 1) == 1)
                res = res * curr % mod;
            curr = curr * curr % mod;
            y >>= 1;
        }
        return res;
    }

    private int[] numOfPrimes(int n) {
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
