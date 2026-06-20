package easy;

// 2309. Greatest English Letter in Upper and Lower Case

public class Solution2309 {
    public String greatestLetter(String s) {
        long mask = 0l;
        for (char c : s.toCharArray())
            mask |= (1l << (c - 'A')); // 1必须是long类型
        mask &= (mask >> ('a' - 'A'));
        if (mask == 0)
            return "";
        int l = 64 - Long.numberOfLeadingZeros(mask);
        return String.valueOf((char) ('A' + l - 1));
    }
}
