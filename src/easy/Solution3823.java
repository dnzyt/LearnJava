package easy;

// 3823. Reverse Letters Then Special Characters in a String

import java.util.function.Predicate;

public class Solution3823 {
    public String reverseByType(String s) {
        char[] chs = s.toCharArray();
        reverse(chs, ch -> 'a' <= ch && ch <= 'z');
        reverse(chs, ch -> !('a' <= ch && ch <= 'z'));
        return new String(chs);
    }

    private void reverse(char[] chs, Predicate<Character> f) {
        int n = chs.length;
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < j && f.test(chs[i]))
                i++;
            while (i < j && f.test(chs[j]))
                j--;
            char t = chs[i];
            chs[i] = chs[j];
            chs[j] = t;
            i++;
            j--;
        }
    }
}
