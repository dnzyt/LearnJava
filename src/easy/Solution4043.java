package easy;

// 4043. Count Rotations With Exactly K Equal Adjacent Pairs

public class Solution4043 {
    public int countRotations(String s, int k) {
        int score = 0;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                score++;
        }
        s = s + s;
        int j = 0, ans = score == k ? 1 : 0;
        for (int i = n; i < n * 2 - 1; i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                score++;
            if (s.charAt(j) == s.charAt(j + 1))
                score--;
            j++;
            if (score == k)
                ans++;
        }
        return ans;
    }
}
