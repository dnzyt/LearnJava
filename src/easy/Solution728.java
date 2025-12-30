package easy;

// 728. Self Dividing Numbers

import java.util.ArrayList;
import java.util.List;

public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            int t = num;
            while (t > 0) {
                int x = t % 10;
                if (t % x != 0)
                    break;
                t /= 10;
            }
            if (t == 0)
                ans.add(num);
        }
        return ans;
    }


}
