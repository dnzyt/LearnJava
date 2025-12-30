package easy;

// 796. Rotate String

public class Solution796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        s = s + s;
        return s.indexOf(goal) != -1;
    }
}
