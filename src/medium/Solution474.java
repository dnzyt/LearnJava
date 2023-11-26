package medium;

// 474. Ones and Zeroes

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Solution474 {
    // 01背包问题
    public int findMaxForm(String[] strs, int m, int n) {
        List<Pair<Integer, Integer>> count = new ArrayList<>();
        for (String str : strs) count.add(getBinary(str));
        Pair<Integer, Integer> total = count.stream().reduce((a, b) -> new Pair<>(a.getKey() + b.getKey(), a.getValue() + b.getValue())).orElseThrow();
        int[][][] dp = new int[strs.length + 1][Math.min(total.getKey(), m) + 1][Math.min(total.getValue(), n) + 1];

        int res = 0;
        for (int i = 1; i <= strs.length; i++)
            for (int j = 0; j <= Math.min(total.getKey(), m); j++)
                for (int k = 0; k <= Math.min(total.getValue(), n); k++) {
                    int count0 = count.get(i - 1).getKey();
                    int count1 = count.get(i - 1).getValue();
                    if (j - count0 >= 0 && k - count1 >= 0) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], 1 + dp[i - 1][j - count0][k - count1]);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
        return dp[strs.length][Math.min(m, total.getKey())][Math.min(n, total.getValue())];
    }

    public Pair<Integer, Integer> getBinary(String s) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                zero += 1;
            else
                one += 1;
        }
        return new Pair<>(zero, one);
    }

}
