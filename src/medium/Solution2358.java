package medium;

// 2358. Maximum Number of Groups Entering a Competition

public class Solution2358 {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        return (int) (-1 + Math.sqrt(1 + 8 * n)) / 2;
    }
}
