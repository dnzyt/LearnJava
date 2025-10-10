package medium;

// 3211. Generate Binary Strings Without Adjacent Zeros

import java.util.ArrayList;
import java.util.List;

public class Solution3211 {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            int mask = (1 << n) - 1;
            int x = i ^ mask;
            if ((x & (x >> 1)) == 0)
                ans.add(Integer.toBinaryString((1 << n) | i).substring(1));
        }
        return ans;
    }
}

/*
 * 判断是num否有两个连续的1，可以把num右移一位然后&，看结果是否等于0
 *
 * 对一个数取反，用全1去异或这个数
 * e.g.  mask = 0b11111111
 *       num的反 = mask^num
 * */
