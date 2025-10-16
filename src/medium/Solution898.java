package medium;

// 898. Bitwise ORs of Subarrays

import java.util.HashSet;
import java.util.Set;

public class Solution898 {
    // LogTrick
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> ans = new HashSet<>();
        for (int j = 0; j < n; j++) {
            ans.add(arr[j]);
            for (int i = j - 1; i >= 0; i--) {
                if ((arr[i] | arr[j]) == arr[i]) break;
                arr[i] |= arr[j];
                ans.add(arr[i]);
            }
        }
        return ans.size();
    }
}
