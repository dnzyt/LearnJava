package medium;

// 1401. Circle and Rectangle Overlapping

public class Solution1401 {

    // 把圆在长方形的边上滚一圈
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if (isInRect(xCenter, yCenter, x1 - radius, y1, x2 + radius, y2)) return true;
        if (isInRect(xCenter, yCenter, x1, y1 - radius, x2, y2 + radius)) return true;
        if (getDist(xCenter, yCenter, x1, y1) <= radius) return true;
        if (getDist(xCenter, yCenter, x1, y2) <= radius) return true;
        if (getDist(xCenter, yCenter, x2, y1) <= radius) return true;
        if (getDist(xCenter, yCenter, x2, y2) <= radius) return true;
        return false;
    }

    private boolean isInRect(int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        return xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2;
    }

    private double getDist(int x, int y, int a, int b) {
        return Math.sqrt(Math.pow(Math.abs(x - a), 2) + Math.pow(Math.abs(y - b), 2));
    }
}
