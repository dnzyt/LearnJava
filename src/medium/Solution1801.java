package medium;

// 1801. Number of Orders in the Backlog

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1801 {
    private static final int MOD = 1_000_000_007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>(Comparator.comparing(a -> -a[0]));
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int orderType = order[2];
            if (orderType == 0) {
                if (sell.isEmpty() || sell.peek()[0] > price) {
                    buy.offer(new int[]{price, amount});
                } else {
                    while (!sell.isEmpty() && sell.peek()[0] <= price && amount > 0) {
                        int[] sellOrder = sell.poll();
                        if (sellOrder[1] > amount) {
                            sellOrder[1] -= amount;
                            amount = 0;
                            sell.offer(sellOrder);
                        } else {
                            amount -= sellOrder[1];
                        }
                    }
                    if (amount > 0)
                        buy.offer(new int[]{price, amount});

                }
            } else {
                if (buy.isEmpty() || buy.peek()[0] < price)
                    sell.offer(new int[]{price, amount});
                else {
                    while (!buy.isEmpty() && buy.peek()[0] >= price && amount > 0) {
                        int[] buyOrder = buy.poll();
                        if (buyOrder[1] > amount) {
                            buyOrder[1] -= amount;
                            amount = 0;
                            buy.offer(buyOrder);
                        } else {
                            amount -= buyOrder[1];
                        }
                    }
                    if (amount > 0) {
                        sell.offer(new int[]{price, amount});
                    }
                }
            }
        }
        int ans = 0;
        for (int[] o : buy) {
            ans = (ans + o[1]) % MOD;
        }
        for (int[] o : sell) {
            ans = (ans + o[1]) % MOD;
        }
        return ans;
    }
}
