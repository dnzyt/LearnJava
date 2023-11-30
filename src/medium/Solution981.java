package medium;

// 981. Time Based Key-Value Store

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution981 {

    static class TimeMap {
        Map<String, List<Pair<Integer, String>>> store;

        public TimeMap() {
            store = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
        }

        public String get(String key, int timestamp) {
            List<Pair<Integer, String>> vals = store.get(key);
            if (vals == null)
                return "";
            String res = "";
            int l = 0, r = vals.size() - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (vals.get(mid).getKey() <= timestamp) {
                    res = vals.get(mid).getValue();
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return res;
        }
    }

}
