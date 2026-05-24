package medium;

// 245. Shortest Word Distance III

public class Solution245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            int pre = -1;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    if (pre >= 0)
                        ans = Math.min(ans, i - pre);
                    pre = i;
                }
            }
        } else {
            int idx1 = -1, idx2 = -1;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1))
                    idx1 = i;
                if (wordsDict[i].equals(word2))
                    idx2 = i;
                if (idx1 != -1 && idx2 != -1)
                    ans = Math.min(ans, Math.abs(idx1 - idx2));
            }
        }
        return ans;
    }
}
