package medium;

// 3775. Reverse Words With Same Vowel Count

public class Solution3775 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int firstCount = countVowel(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (countVowel(words[i]) == firstCount) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ", words);
    }

    private int countVowel(String w) {
        int cnt = 0;

        for (char c : w.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0)
                cnt++;
        }
        return cnt;
    }
}
