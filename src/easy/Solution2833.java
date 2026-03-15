package easy;

// 2833. Furthest Point From Origin

public class Solution2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'R')
                r++;
            else if (ch == 'L')
                l++;
        }
        return moves.length() - (l + r) + Math.abs(l - r);
    }
}
