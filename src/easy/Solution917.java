package easy;

// 917. Reverse Only Letters

public class Solution917 {
    public String reverseOnlyLetters(String s) {
        char[] chs = s.toCharArray();
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; ) {
            while (i < j && !Character.isLetter(chs[i])) i++;
            while (i < j && !Character.isLetter(chs[j])) j--;
            if (i < j) {
                char t = chs[i];
                chs[i++] = chs[j];
                chs[j--] = t;
            }
        }
        return String.valueOf(chs);
    }
}
