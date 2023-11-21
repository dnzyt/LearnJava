package medium;

import java.util.Stack;

public class Solution2434 {
    public String robotWithString(String s) {
        char[] ss = s.toCharArray();
        char[] suff = new char[ss.length];
        char smallest = 'z';
        for (int i = ss.length-1; i >= 0; i--) {
            smallest = ss[i] < smallest ? ss[i] : smallest;
            suff[i] = smallest;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < ss.length) {
            if (stack.empty() || stack.peek() > suff[i]) {
                stack.push(ss[i]);
                i ++;
            } else {
                sb.append(stack.pop());
            }
        }
        while (!stack.empty())
            sb.append(stack.pop());
        return sb.toString();
    }
}
