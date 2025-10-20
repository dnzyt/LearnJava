package easy;

// 682. Baseball Game

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution682 {
    public int calPoints(String[] operations) {
        Deque<Integer> s = new ArrayDeque<>();
        for (String op : operations) {
            switch (op.charAt(0)) {
                case '+':
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b);
                    s.push(a);
                    s.push(a + b);
                    break;
                case 'D':
                    int x = s.pop();
                    s.push(x);
                    s.push(x * 2);
                    break;
                case 'C':
                    s.pop();
                    break;
                default:
                    s.push(Integer.parseInt(op));
            }
        }
        int ans = 0;
        for (int a : s)
            ans += a;
        return ans;
    }
}
