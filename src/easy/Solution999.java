package easy;

// 999. Available Captures for Rook

public class Solution999 {
    public int numRookCaptures(char[][] board) {
        int[] rook = new int[]{0, 0};
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    rook[0] = i;
                    rook[1] = j;
                    break;
                }
            }
        }
        int ans = 0;
        // UP
        for (int i = rook[0] - 1; i >= 0; i--) {
            if (board[i][rook[1]] == 'p')
                ans++;
            else if (board[i][rook[1]] == 'B') {
                break;
            }
        }

        // DOWN
        for (int i = rook[0] + 1; i < m; i++) {
            if (board[i][rook[1]] == 'p')
                ans++;
            else if (board[i][rook[1]] == 'B')
                break;
        }

        // LEFT
        for (int j = rook[1] - 1; j >= 0; j--) {
            if (board[rook[0]][j] == 'p')
                ans++;
            else if (board[rook[0]][j] == 'B')
                break;
        }

        // RIGHT
        for (int j = rook[1] + 1; j < n; j++) {
            if (board[rook[0]][j] == 'p')
                ans++;
            else if (board[rook[0]][j] == 'B')
                break;
        }
        return ans;

    }
}
