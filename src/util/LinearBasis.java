package util;

public class LinearBasis {
    private static final int MAXN = 1000; // 1000 个数
    private static final int BIT = 60;    // 每个数最多60个bit
    private static long[] arr = new long[MAXN];
    private static int n; // 原始数组中的数字个数为n
    private static long[] basis1 = new long[BIT + 1]; // 用来存线性基
    private static boolean zero; // 是否能组成0

    // 普通消元
    public static void compute1() {
        zero = false;
        for (int i = 0; i < n; i++) {
            if (!insert(arr[i]))
                zero = true;
        }
    }

    private static boolean insert(long num) {
        for (int i = BIT - 1; i >= 0; i--) {
            if ((num & (1l << i)) > 0) {
                if (basis1[i] == 0) {
                    basis1[i] = num;
                    return true;
                }
                num ^= basis1[i];
            }
        }
        return false;
    }
}
