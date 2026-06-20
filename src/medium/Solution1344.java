package medium;

// 1344. Angle Between Hands of a Clock

public class Solution1344 {
    public double angleClock(int hour, int minutes) {
        if (hour == 12)
            hour = 0;
        double a = Math.abs(6 * minutes - (30 * hour + 0.5 * minutes));
        double b = 360.0 - a;
        return Math.min(a, b);
    }
}
