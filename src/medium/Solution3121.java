package medium;

// 3121. Count the Number of Special Characters II

public class Solution3121 {
    public int numberOfSpecialChars(String word) {
        int[] state = new int[27];
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                int idx = ch & 31;
                if (state[idx] == 0)
                    state[idx] = 1;
                else if (state[idx] == 2)
                    state[idx] = -1;
            } else {
                int idx = ch & 31;
                if (state[idx] == 0)
                    state[idx] = -1;
                else if (state[idx] == 1)
                    state[idx] = 2;
            }
        }
        int ans = 0;
        for (int i = 0; i < state.length; i++)
            ans += state[i] == 2 ? 1 : 0;
        return ans;
    }
}
