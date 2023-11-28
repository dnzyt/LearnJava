package medium;

// 150. Evaluate Reverse Polish Notation

import java.util.Stack;

public class Solution150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            int a, b;
            switch (token) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    a = stack.pop();
                    b= stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b= stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    a = stack.pop();
                    b= stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

}
