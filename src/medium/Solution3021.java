package medium;

// 3021. Alice and Bob Playing Flower Game

public class Solution3021 {
    public long flowerGame(int n, int m) {
        long upOdd = (n + 1) / 2;
        long downOdd = (m + 1) / 2;
        return upOdd * (m - downOdd) + (n - upOdd) * downOdd;
    }

    public long flowerGame2(int n, int m) {
        return (long) n * m / 2;
    }
}
