package easy;

// 806. Number of Lines To Write String

public class Solution806 {
    public int[] numberOfLines(int[] widths, String s) {
        int numOfLines = 0;
        int lineWidth = 0;
        for (char c : s.toCharArray()) {
            if (lineWidth + widths[c - 'a'] <= 100) {
                lineWidth += widths[c - 'a'];
            } else {
                numOfLines++;
                lineWidth = widths[c - 'a'];
            }
        }
        return new int[]{numOfLines + 1, lineWidth};
    }
}
