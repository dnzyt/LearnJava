package easy;

// 3019. Number of Changing Keys

public class Solution3019 {
    public int countKeyChanges(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++)
            if ((s.charAt(i - 1) & 31) != (s.charAt(i) & 31))
                ans++;
        return ans;
    }
}
