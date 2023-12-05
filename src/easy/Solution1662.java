package easy;

// 1662. Check If Two String Arrays are Equivalent

public class Solution1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb = new StringBuffer();
        int j = 0;
        for (String word : word1) {
            sb.append(word);
            while (j < word2.length) {
                String curr = sb.toString();
                if (curr.length() >= word2[j].length()) {
                    if (curr.startsWith(word2[j])) {
                        sb = new StringBuffer(sb.substring(word2[j].length()));
                        j ++;
                    } else {
                        return false;
                    }
                } else break;
            }
        }
        if (sb.toString().isEmpty() && j == word2.length)
            return true;
        return false;

    }
}
