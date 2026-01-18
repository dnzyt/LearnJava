package medium;

// 3815. Design Auction System

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution3815 {

    // 懒删除堆
    // 往里加元素的时候正常加
    // 出堆的时候看值是否合法
    class AuctionSystem {
        Map<Integer, Integer> ui2price;
        Map<Integer, PriorityQueue<int[]>> item2userAmount;

        public AuctionSystem() {
            ui2price = new HashMap<>();
            item2userAmount = new HashMap<>();
        }

        public void addBid(int userId, int itemId, int bidAmount) {
            int key = (userId << 16) | itemId;
            ui2price.put(key, bidAmount);
            item2userAmount.computeIfAbsent(itemId, k ->
                            new PriorityQueue<>((a, b) -> a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]))
                    .offer(new int[]{userId, bidAmount});
        }

        public void updateBid(int userId, int itemId, int newAmount) {
            addBid(userId, itemId, newAmount);
        }

        public void removeBid(int userId, int itemId) {
            ui2price.remove((userId << 16) | itemId);
        }

        public int getHighestBidder(int itemId) {
            PriorityQueue<int[]> q = item2userAmount.get(itemId);
            if (q == null)
                return -1;
            while (!q.isEmpty()) {
                int[] curr = q.peek();
                if (curr[1] == ui2price.getOrDefault((curr[0] << 16) | itemId, -1))
                    return curr[0];
                q.poll();
            }
            return -1;
        }
    }
}
