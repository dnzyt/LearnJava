package medium;

// 3305. Count of Substrings Containing Every Vowel and K Consonants I

import java.util.*;

public class Solution3305 {
    private static final Set<Character> VOWELS = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
    private static final Map<Character, Integer> cntVowels = new HashMap<>();
    private static int cntCon;

    public int countOfSubstrings(String word, int k) {
        return f(word, k) - f(word, k + 1);
    }

    // 恰好型题目，要利用f(k) - f(k + 1)或者f(k) - f(k - 1)
    // 恰好为k，等价于 至少为k的情况 - 至少为k+1的情况
    private int f(String word, int k) {
        cntVowels.clear();
        cntCon = 0;
        int n = word.length();
        char[] chs = word.toCharArray();
        int ans = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (VOWELS.contains(chs[j])) {
                cntVowels.merge(chs[j], 1, Integer::sum);
            } else {
                cntCon++;
            }
            while (i <= j && cntVowels.size() == 5 && cntCon >= k) {
                if (VOWELS.contains(chs[i])) {
                    cntVowels.merge(chs[i], -1, Integer::sum);
                    if (cntVowels.get(chs[i]) == 0)
                        cntVowels.remove(chs[i]);
                } else {
                    cntCon--;
                }
                i++;
            }
            ans += i;
        }
        return ans;
    }
}
