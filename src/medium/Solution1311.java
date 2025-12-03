package medium;

// 1311. Get Watched Videos by Your Friends

import javafx.util.Pair;

import java.util.*;

public class Solution1311 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(id);
        visited[id] = true;
        while (!q.isEmpty()) {
            int l = q.size();
            level--;
            while (l-- > 0) {
                int curr = q.poll();
                for (int nxt : friends[curr]) {
                    if (!visited[nxt]) {
                        q.offer(nxt);
                        visited[nxt] = true;
                    }
                }
            }
            if (level == 0)
                break;
        }
        Map<String, Integer> count = new HashMap<>();
        for (int f : q) {
            for (String movie : watchedVideos.get(f)) {
                count.merge(movie, 1, Integer::sum);
            }
        }
        List<String> ans = new ArrayList<>();

        count.entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue).thenComparing(Map.Entry::getKey))
                .forEach(e -> ans.add(e.getKey()));

//        List<Pair<String, Integer>> s = new ArrayList<>();
//        for (String k : count.keySet()) {
//            s.add(new Pair<>(k, count.get(k)));
//        }
//        s.sort(Comparator.<Pair<String, Integer>>comparingInt(Pair::getValue).thenComparing(Pair::getKey));

//        for (Pair<String, Integer> p : s)
//            ans.add(p.getKey());
        return ans;
    }
}
