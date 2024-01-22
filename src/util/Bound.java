package util;

import java.util.List;

public class Bound {
    public static int lowerBound(List<Integer> arr, int num) {
        int left = 0, right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int upperBound(List<Integer> arr, int num) {
        int left = 0, right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
