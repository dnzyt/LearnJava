package easy;

// 482. License Key Formatting

public class Solution482 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray())
            if (ch != '-')
                sb.append(Character.toUpperCase(ch));
        String ss = sb.reverse().toString();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < ss.length()) {
            ans.append(ss.substring(i, Math.min(i + k, ss.length())));
            if (i + k < ss.length())
                ans.append("-");
            i += k;
        }
        return ans.reverse().toString();
    }
}
