package easy;

// 551. Student Attendance Record I

import java.util.HashMap;
import java.util.Map;

public class Solution551 {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A')
                a++;
            if (s.charAt(i) == 'L') {
                if (i + 2 < s.length() && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L')
                    l++;
            }
        }
        return a < 2 && l == 0;
    }
}
