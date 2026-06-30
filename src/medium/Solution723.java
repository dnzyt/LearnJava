package medium;

// 723. Candy Crush

public class Solution723 {
    public int[][] candyCrush(int[][] board) {
        int row = board.length, col = board[0].length;
        boolean modified = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col - 2; j++) {
                int v = Math.abs(board[i][j]);
                if (v != 0 && v == Math.abs(board[i][j + 1]) && v == Math.abs(board[i][j + 2])) {
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                    modified = true;
                }
            }
        }
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row - 2; i++) {
                int v = Math.abs(board[i][j]);
                if (v != 0 && v == Math.abs(board[i + 1][j]) && v == Math.abs(board[i + 2][j])) {
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
                    modified = true;
                }
            }
        }

        for (int j = 0; j < col; j++) {
            int wr = row - 1;
            for (int i = row - 1; i >= 0; i--) {
                if (board[i][j] > 0) {
                    board[wr--][j] = board[i][j];
                }
            }
            while (wr >= 0)
                board[wr--][j] = 0;
        }

        return modified ? candyCrush(board) : board;

    }
}
