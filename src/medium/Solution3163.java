package medium;

// 3163. String Compression III

public class Solution3163 {
    public String compressedString(String word) {
        int n = word.length();
        char[] chs = word.toCharArray();
        int start = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (i + 1 == n || chs[i] != chs[i + 1]) {
                int l = i - start + 1;
                start = i + 1;
                while (l / 9 > 0) {
                    sb.append(9);
                    sb.append(chs[i]);
                    l -= 9;
                }
                if (l > 0) {
                    sb.append(l);
                    sb.append(chs[i]);
                }
            }
        }
        return sb.toString();
    }
}
