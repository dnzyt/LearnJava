package easy;

// 1967. Number of Strings That Appear as Substrings in Word

public class Solution1967 {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String p : patterns) {
            if (word.contains(p))
                ans++;
        }
        return ans;
    }
}
