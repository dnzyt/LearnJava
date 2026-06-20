package hard;

// 2296. Design a Text Editor

public class Solution2296 {

    // 对顶栈解法

    class TextEditor {
        private StringBuilder left;
        private StringBuilder right;

        public TextEditor() {
            left = new StringBuilder();
            right = new StringBuilder();

        }

        public void addText(String text) {
            left.append(text);
        }

        public int deleteText(int k) {
            int cnt = 0;
            while (!left.isEmpty() && k > 0) {
                left.deleteCharAt(left.length() - 1);
                cnt++;
                k--;
            }
            return cnt;
        }

        public String cursorLeft(int k) {
            StringBuilder s = new StringBuilder();
            while (!left.isEmpty() && k > 0) {
                char c = left.charAt(left.length() - 1);
                right.append(c);
                left.deleteCharAt(left.length() - 1);
                k--;
            }
            for (int i = 0; i < Math.min(10, left.length()); i++) {
                s.append(left.charAt(left.length() - 1 - i));
            }
            return s.reverse().toString();
        }

        public String cursorRight(int k) {
            StringBuilder s = new StringBuilder();
            while (!right.isEmpty() && k > 0) {
                char c = right.charAt(right.length() - 1);
                left.append(c);
                right.deleteCharAt(right.length() - 1);
                k--;
            }
            for (int i = 0; i < Math.min(10, left.length()); i++) {
                s.append(left.charAt(left.length() - 1 - i));
            }
            return s.reverse().toString();
        }
    }
}
