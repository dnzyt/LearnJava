package medium;

import java.util.*;

public class Solution355 {
    class Twitter {

        private Map<Integer, User> users;
        private int time;

        public Twitter() {
            users = new HashMap<>();
            time = 0;
        }

        public void postTweet(int userId, int tweetId) {
            if (!users.containsKey(userId))
                users.put(userId, new User(userId));
            User curr = users.get(userId);
            curr.tweets.offer(new Tweet(tweetId, time++));
            if (curr.tweets.size() > 10)
                curr.tweets.poll();
        }

        public List<Integer> getNewsFeed(int userId) {
            User curr = users.get(userId);
            if (curr == null)
                return Collections.emptyList();
            PriorityQueue<Tweet> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.timestamp));
            List<Integer> ans = new ArrayList<>();
            for (int followeeId : curr.following) {
                User f = users.get(followeeId);
                for (Tweet t : f.tweets) {
                    pq.offer(t);
                    if (pq.size() > 10)
                        pq.poll();
                }
            }
            for (Tweet t : curr.tweets) {
                pq.offer(t);
                if (pq.size() > 10)
                    pq.poll();
            }
            while (!pq.isEmpty()) {
                Tweet t = pq.poll();
                ans.add(t.tweetId);
            }
            Collections.reverse(ans);
            return ans;
        }

        public void follow(int followerId, int followeeId) {
            if (!users.containsKey(followerId))
                users.put(followerId, new User(followerId));
            if (!users.containsKey(followeeId))
                users.put(followeeId, new User(followeeId));

            User curr = users.get(followerId);
            curr.following.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (!users.containsKey(followerId))
                users.put(followerId, new User(followerId));
            if (!users.containsKey(followeeId))
                users.put(followeeId, new User(followeeId));
            User curr = users.get(followerId);
            curr.following.remove(followeeId);
        }

        record Tweet(int tweetId, int timestamp) {
        }

        class User {
            public int id;
            public Set<Integer> following;
            public Deque<Tweet> tweets;

            public User(int id) {
                this.id = id;
                this.following = new HashSet<Integer>();
                this.tweets = new ArrayDeque<Tweet>();
            }
        }
    }
}
