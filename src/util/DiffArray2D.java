package util;

public class DiffArray2D {

    public int[][] diff;
    public int[][] f;
    public int row;
    public int col;

    public DiffArray2D(int m, int n) {
        this.row = m;
        this.col = n;
        this.diff = new int[m + 1][n + 1];
        this.f = new int[m][n];
    }

    public void flood(int x0, int y0, int x1, int y1) {
        this.diff[x0][y0] += 1;
        this.diff[x0][y1 + 1] -= 1;
        this.diff[x1 + 1][y0] -= 1;
        this.diff[x1 + 1][y1 + 1] += 1;
    }

    public void compute() {
        for (int i = 0; i < this.row; i++)
            for (int j = 0; j < this.col; j++) {
                int a = i == 0 ? 0 : this.f[i - 1][j];
                int b = j == 0 ? 0 : this.f[i][j - 1];
                int c = (i == 0 || j == 0) ? 0 : this.f[i - 1][j - 1];
                this.f[i][j] = a + b - c + this.diff[i][j];
            }
    }
}
