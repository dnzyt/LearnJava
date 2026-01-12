package medium;

// 2410. Maximum Matching of Players With Trainers

import java.util.Arrays;

public class Solution2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int j = 0;
        int m = trainers.length;
        for (int i = 0; i < players.length; i++) {
            while (j < m && players[i] > trainers[j])
                j++;
            if (j == m)
                return i;
            j++;
        }
        return players.length;
    }
}
