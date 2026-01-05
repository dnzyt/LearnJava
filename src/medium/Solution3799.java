package medium;

// 3799. Word Squares II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3799 {
    public List<List<String>> wordSquares(String[] words) {
        int n = words.length;
        Arrays.sort(words);

        int[] path = new int[4];
        boolean[] onPath = new boolean[n];
        List<List<String>> ans = new ArrayList<>();

        dfs(0, path, onPath, words, ans);

        return ans;
    }

    private void dfs(int i, int[] path, boolean[] onPath, String[] words, List<List<String>> ans) {
        if (i == 4) {
            String top = words[path[0]];
            String left = words[path[1]];
            String right = words[path[2]];
            String bottom = words[path[3]];
            if (top.charAt(0) == left.charAt(0) &&
                    top.charAt(3) == right.charAt(0) &&
                    bottom.charAt(0) == left.charAt(3) &&
                    bottom.charAt(3) == right.charAt(3))
                ans.add(List.of(top, left, right, bottom));
            return;
        }
        int n = onPath.length;
        for (int j = 0; j < n; j++) {
            if (!onPath[j]) {
                path[i] = j;
                onPath[j] = true;
                dfs(i + 1, path, onPath, words, ans);
                onPath[j] = false;
            }
        }
    }

}
