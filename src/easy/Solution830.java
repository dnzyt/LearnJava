package easy;

// 830. Positions of Large Groups

import java.util.ArrayList;
import java.util.List;

public class Solution830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length();
        char[] chs = s.toCharArray();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j + 1 < n && chs[j] == chs[j + 1])
                j++;
            if (j - i + 1 >= 3)
                ans.add(List.of(i, j));
            i = j + 1;
        }

        return ans;
    }
}
