package hard;

// 3953. Maximum Score with Co-Prime Element

import java.util.*;

public class Solution3953 {

    private static final int MX = 100000;
    private static int[] mu;
    private static List<Integer>[] divisors;
    private static boolean initialized = false;


    public Solution3953() {
        if (initialized)
            return;
        initialized = true;
        mu = mobiuz(MX);
        divisors = new List[MX + 1];
        Arrays.setAll(divisors, i -> new ArrayList<>());
        for (int i = 2; i <= MX; i++) {
            if (mu[i] != 0) {
                for (int j = i; j <= MX; j += i)
                    divisors[j].add(i);
            }
        }
    }

    private int[] mobiuz(int n) {
        int[] mu = new int[n + 1];
        boolean[] isPrime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        Arrays.fill(isPrime, true);
        mu[1] = 1;
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

    public int maxScore(int[] nums, int maxVal) {
        int maxNum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            cnt.merge(num, 1, Integer::sum);
        }
        Map<Integer, Integer> cntMulti = new HashMap<>();
        for (int i = 2; i <= maxNum; i++) {
            for (int j = i; j <= maxNum; j += i)
                cntMulti.merge(i, cnt.getOrDefault(j, 0), Integer::sum);
        }
        int ans = cnt.containsKey(1) ? 1 : 0;
        for (int selectedValue = Math.max(maxNum, maxVal); selectedValue > 0; selectedValue--) {
            if (selectedValue <= ans)
                break;
            if (selectedValue > maxVal && !cnt.containsKey(selectedValue))
                continue;
            int cost = 0;
            for (int d : divisors[selectedValue]) {
                if (d > maxNum)
                    break;
                cost -= mu[d] * cntMulti.getOrDefault(d, 0);
            }
            if (cnt.containsKey(selectedValue))
                cost--;
            else if (cost == 0)
                cost = 1;
            ans = Math.max(ans, selectedValue - cost);
        }

        return ans;
    }
}
