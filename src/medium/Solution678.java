package medium;

// 678. Valid Parenthesis String

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution678 {

    public boolean checkValidString(String s) {
        int countMin = 0, countMax = 0; // countMin: 尽可能少的积累左括号
        for (char c : s.toCharArray()) {
            if (c == '(') {
                countMin++;
                countMax++;
            } else if (c == ')') {
                countMin--;
                countMax--;
            } else {
                countMin--;
                countMax++;
            }
            if (countMax < 0)
                return false;
            if (countMin < 0)
                countMin = 0;
        }
        return countMin == 0;
    }
}
