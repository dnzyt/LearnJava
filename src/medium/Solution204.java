package medium;

// 204. Count Primes

import java.util.ArrayList;
import java.util.List;

public class Solution204 {
    // 埃氏筛
    public int countPrimes(int n) {
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 2; i * i < n; i++) {
            if (!visited[i]) {
                for (int j = i * i; j > 0 && j < n; j += i)
                    visited[j] = true;
            }
        }
        for (int i = 2; i < visited.length; i++)
            if (!visited[i])
                cnt++;
        return cnt;
    }

    // 欧拉筛
    public int countPrimes2(int n) {
//        List<Integer> primes = new ArrayList<>(); 太慢，用数组快
        boolean[] visited = new boolean[n];
        int[] primes = new int[n / 2 + 1]; // 所有的奇数再加一个2，不会超过n/2 + 1
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!visited[i])
                primes[cnt++] = i;
            for (int j = 0; j < cnt && i * primes[j] < n; j++) {
                visited[i * primes[j]] = true;
                if (i % primes[j] == 0)
                    break;
            }
        }
        return cnt;
    }
}
