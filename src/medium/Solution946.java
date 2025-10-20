package medium;

// 946. Validate Stack Sequences

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = popped.length;
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0, j = 0;
        while (i < n) {
            int curr = popped[i];
            if (!q.isEmpty()) {
                if (q.peek() == curr) {
                    q.pop();
                    i++;
                    continue;
                } else if (j == n) {
                    return false;
                }
            }
            if (j < pushed.length) {
                q.push(pushed[j]);
                j++;
            }

        }
        return true;
    }
}
