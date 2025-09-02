package medium;

// 740. Delete and Earn

public class Solution740 {

    public int deleteAndEarn(int[] nums) {
        int mx = 0;
        for (int num : nums) mx = Math.max(mx, num);
        // 把nums转换成值域数组
        // 转换之后这个问题就变成了打家劫舍
        int[] f = new int[mx + 1];
        for (int num : nums) f[num] += num;
        return rob(f);
    }

    private int rob(int[] nums) {
        int f0 = 0;
        int f1 = 0;
        for (int num : nums) {
            int newF = Math.max(f0 + num, f1);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }
}
