package medium;

// 621. Task Scheduler

import javafx.util.Pair;

import java.util.Arrays;

public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 65] += 1;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idleTime = (maxFreq - 1) * n;
        for (int i = 24; i >= 0; i--) {
            if (idleTime <= 0)
                break;
            idleTime -= Math.min(maxFreq - 1, freq[i]);
        }
        idleTime = Math.max(0, idleTime);
        return idleTime + tasks.length;
    }
}
/*
* 假设最大频率为 A, 如果有多个最大频率的task， 那么这些task只占用maxFreq - 1 个 idle
* 看最后一行之前能剩余多少 idle ， 这些idel是必须要的，这些 idle 加上 task 的数量就是所需要的时间
* A B X X X X X
* A B X X X X X
* A B X X X X X
* A B
*
* */
