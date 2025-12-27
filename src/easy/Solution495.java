package easy;

// 495. Teemo Attacking

public class Solution495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = duration;
        int n = timeSeries.length;
        for (int i = 0; i < n - 1; i++) {
            if (timeSeries[i] + duration <= timeSeries[i + 1])
                total += duration;
            else
                total += timeSeries[i + 1] - timeSeries[i];
        }
        return total;
    }
}
