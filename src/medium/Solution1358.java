package medium;

// 1358. Number of Substrings Containing All Three Characters

public class Solution1358 {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        int cntA = 0, cntB = 0, cntC = 0;
        int i = 0, ans = 0;
        for (int j = 0; j < n; j++) {
            char curr = chs[j];
            if (curr == 'a')
                cntA++;
            else if (curr == 'b')
                cntB++;
            else if (curr == 'c')
                cntC++;
            while (cntA > 0 && cntB > 0 && cntC > 0) {
                curr = chs[i];
                if (curr == 'a')
                    cntA--;
                else if (curr == 'b')
                    cntB--;
                else if (curr == 'c')
                    cntC--;
                i++;
            }
            ans += i;
        }
        return ans;
    }
}
