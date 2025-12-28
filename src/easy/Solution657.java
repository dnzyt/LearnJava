package easy;

// 657. Robot Return to Origin

public class Solution657 {
    public boolean judgeCircle(String moves) {
        int a = 0, b = 0;
        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case 'U':
                    a++;
                    break;
                case 'D':
                    a--;
                    break;
                case 'L':
                    b++;
                    break;
                case 'R':
                    b--;
                    break;
            }
        }

        return a == 0 && b == 0;
    }
}
