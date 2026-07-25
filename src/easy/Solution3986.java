package easy;

// 3986. Number of Elapsed Seconds Between Two Times

public class Solution3986 {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return convert(endTime) - convert(startTime);
    }

    private int convert(String time) {
        String[] components = time.split(":");
        int h = Integer.parseInt(components[0]);
        int m = Integer.parseInt(components[1]);
        int s = Integer.parseInt(components[2]);
        int ans = h * 3600 + m * 60 + s;
        return ans;
    }
}
