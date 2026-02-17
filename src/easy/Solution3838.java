package easy;

// 3838. Weighted Word Mapping

public class Solution3838 {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            int sum = 0;
            for (char ch : word.toCharArray())
                sum += weights[ch - 'a'];
            sum %= 26;
            sb.append((char) ('a' + (25 - sum)));
        }
        return sb.toString();
    }
}
