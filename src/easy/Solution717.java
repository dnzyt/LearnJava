package easy;

// 717. 1-bit and 2-bit Characters

public class Solution717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length) {
            if (i == bits.length - 1)
                return true;
            if (bits[i] == 0)
                i++;
            else i += 2;
        }
        return false;
    }
}
