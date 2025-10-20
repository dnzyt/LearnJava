package medium;

// 1441. Build an Array With Stack Operations

import java.util.ArrayList;
import java.util.List;

public class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (target[idx] == i) {
                ans.add("Push");
                idx++;
                if (idx == target.length)
                    break;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }
}
