package medium;

// 1177. Can Make Palindrome from Substring

import java.util.ArrayList;
import java.util.List;

public class Solution1177 {
    // naive solution
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[][] sum = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i].clone();
            sum[i + 1][c[i] - 'a'] = sum[i][c[i] - 'a'] + 1;
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int left = q[0], right = q[1], k = q[2];
            int count = 0;
            for (int i = 0; i < 26; i++) {
                count += (sum[right + 1][i] - sum[left][i]) % 2;
            }
            ans.add(count / 2 <= k);
        }
        return ans;
    }

    // 前缀异或和
    public List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[][] presum = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i].clone();
            presum[i + 1][c[i] - 'a'] ^= 1;
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int left = q[0], right = q[1], k = q[2];
            int m = 0;
            for (int i = 0; i < 26; i++)
                m += (presum[right + 1][i] ^ presum[left][i]) > 0 ? 1 : 0;
            ans.add(m / 2 <= k);
        }
        return ans;
    }

    // 把前缀异或和压缩到一个整数中
    public List<Boolean> canMakePaliQueries3(String s, int[][] queries) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i];
            presum[i + 1] ^= (1 << (c[i] - 'a'));
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int left = q[0], right = q[1], k = q[2];
            int m = Integer.bitCount(presum[right + 1] ^ presum[left]);
            ans.add(m / 2 <= k);
        }

        return ans;
    }

}
