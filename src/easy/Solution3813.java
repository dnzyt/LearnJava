package easy;

// 3813. Vowel-Consonant Score

public class Solution3813 {
    public int vowelConsonantScore(String s) {
        int v = 0, c = 0;
        for (char ch : s.toCharArray()) {
            if (!Character.isLetter(ch))
                continue;
            if ("aeiou".indexOf(ch) != -1)
                v++;
            else
                c++;
        }
        return c > 0 ? v / c : 0;
    }
}
