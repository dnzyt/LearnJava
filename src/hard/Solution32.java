package hard;

//

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution32 {
    // 自己的解法
    // 左括号用来统计它所包含的valid字串的长度
    public int longestValidParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(0);
            } else {
                if (st.size() == 1) continue;
                int x = st.pop() + 1;
                st.push(st.pop() + x);
            }
            ans = Math.max(ans, st.peek());
        }
        if (st.size() == 1)
            return ans;
        return ans + 1;
    }

    // 栈解法
    // 栈底始终存放最后一个不合法右括号的索引
    public int longestValidParentheses2(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                st.push(i);
            else {
                st.pop();
                if (st.isEmpty())
                    st.push(i);
                else {
                    ans = Math.max(ans, i - st.peek());
                }
            }
        }
        return ans;
    }

    // 正反遍历
    public int longestValidParentheses3(String s) {
        int left = 0, right = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, right);
            } else if (right > left) { // 当有无法匹配的右括号时，重置
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                right++;
            } else if (c == '(') {
                left++;
            }
            if (left == right)
                ans = Math.max(ans, left);
            else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return ans * 2;
    }
}
