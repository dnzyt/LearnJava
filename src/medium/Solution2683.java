package medium;

// 2683. Neighboring Bitwise XOR

public class Solution2683 {
    public boolean doesValidArrayExist(int[] derived) {
        int ans = 0;
        for (int d : derived)
            ans ^= d;
        return ans == 0;
    }
}


/*
 * d[i] = o[i] ^ o[i+1]
 *
 *
 * */
