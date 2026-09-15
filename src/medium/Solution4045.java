package medium;

// 4045. Count Robot Groups

import java.util.ArrayList;
import java.util.List;

public class Solution4045 {
    public int countGroups(int[] position, int[] speed, int distance) {
        List<Integer> poses = new ArrayList<>();
        int n = position.length;
        for (int i = 0; i < n - 1; i++) {
            if (position[i + 1] - position[i] > distance)
                poses.add(i);
        }
        poses.add(n - 1);
        List<Integer> st = new ArrayList<>();
        for (int pos : poses) {
            while (!st.isEmpty() && speed[st.get(st.size() - 1)] > speed[pos])
                st.removeLast();
            st.add(pos);
        }
        return st.size();
    }
}
