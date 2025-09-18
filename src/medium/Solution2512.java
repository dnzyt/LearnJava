package medium;

// 2512. Reward Top K Students

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2512 {
    public List<Integer> topStudents(String[] positive_feedback,
                                     String[] negative_feedback,
                                     String[] report,
                                     int[] student_id,
                                     int k) {

        Map<String, Integer> pm = new HashMap<>();
        Map<String, Integer> nm = new HashMap<>();
        for (String w : positive_feedback)
            pm.put(w, 3);
        for (String w : negative_feedback)
            nm.put(w, -1);
        List<Pair<Integer, Integer>> s = new ArrayList<>();
        for (int i = 0; i < report.length; i++) {
            int sum = 0;
            String[] ws = report[i].split(" ");
            for (String w : ws) {
                sum += pm.getOrDefault(w, 0);
                sum += nm.getOrDefault(w, 0);
            }
            s.add(new Pair<>(student_id[i], sum));
        }
        s.sort((a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        return s.stream().limit(k).map(Pair::getKey).toList();
    }
}
