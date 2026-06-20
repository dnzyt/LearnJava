package easy;

// 2278. Percentage of Letter in String

public class Solution2278 {
    public int percentageLetter(String s, char letter) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (letter == c)
                cnt++;
        }
        return (int) (((double) cnt / s.length()) * 100);
    }
}
