package hard;

// 2835. Minimum Operations to Form Subsequence With Target Sum

/*
统计每一个bit上有多少个1
当前位上的1如果够用，那么剩下的可以向后面的bit进位
如果当前位上的1不够用，那么去寻找后面最近的1来借位

 * 1 - 00000001
 * 2 - 00000010
 * 8 - 00001000
 *
 * 7 - 00000111
 *
 *
 * */


import java.util.List;

public class Solution2835 {

    public int minOperations(List<Integer> nums, int target) {
        int[] counter = new int[33];
        for (Integer num : nums) {
            int idx = 0;
            int digit = 1;
            while (num != digit) {
                digit <<= 1;
                idx ++;
            }
            counter[idx] ++;
        }

        int i = 0;
        int res = 0;
        while (i < 32) {
            if (((target >> i) & 1) == 1) {
                if (counter[i] >= 1) {
                    counter[i + 1] += (counter[i] - 1) / 2;
                    i ++;
                    continue;
                } else {
                    int j = i + 1;
                    while (j < 32) {
                        if (counter[j] > 0) {
                            counter[j] --;
                            res += (j - i);
                            i = j;
                            break;
                        }
                        j ++;
                    }
                    if (j == 32) return -1;
                }
            } else {
                counter[i + 1] += counter[i] / 2;
                i ++;
            }
        }


        return res;
    }

}



