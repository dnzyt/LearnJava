package easy;

// 157. Read N Characters Given Read4

public class Solution157 {
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int idx = 0;
        while (idx < n) {
            int cnt = read4(temp);
            if (cnt == 0)
                break;
            for (int i = 0; i < cnt; i++)
                buf[idx + i] = temp[i];
            idx += cnt;
        }
        return Math.min(idx, n);
    }

    private int read4(char[] buf4) {
        return 0;
    }
}
