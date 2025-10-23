package medium;

// 2216. Minimum Deletions to Make Array Beautiful

import java.util.ArrayList;
import java.util.List;

public class Solution2216 {
    public int minDeletion(int[] nums) {
        List<Integer> st = new ArrayList<>();
        for (int num : nums) {
            if (st.size() % 2 == 0)
                st.add(num);
            else {
                int last = st.get(st.size() - 1);
                if (last != num)
                    st.add(num);
            }
        }
        if (st.size() % 2 != 0)
            st.remove(st.size() - 1);
        return nums.length - st.size();
    }
}
