package easy;

// 243. Shortest Word Distance

public class Solution243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int a = -1, b = -1, ans = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            String w = wordsDict[i];
            if (w.equals(word1))
                a = i;
            if (w.equals(word2))
                b = i;
            if (a != -1 && b != -1)
                ans = Math.min(ans, Math.abs(a - b));
        }
        return ans;
    }
}
