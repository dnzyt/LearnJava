package easy;

// 506. Relative Ranks

import java.util.Comparator;
import java.util.TreeMap;

public class Solution506 {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }
        String[] ans = new String[n];
        int idx = 1;
        for (int i : map.values()) {
            switch (idx) {
                case 1:
                    ans[i] = "Gold Medal";
                    break;
                case 2:
                    ans[i] = "Silver Medal";
                    break;
                case 3:
                    ans[i] = "Bronze Medal";
                    break;
                default:
                    ans[i] = String.valueOf(idx);
            }
            idx++;
        }
        return ans;
    }
}
