package medium;

// 3885. Design Event Manager

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution3885 {

    class EventManager {
        private record Event(int id, int priority) {
        }

        private Map<Integer, Integer> events;
        private PriorityQueue<Event> pq;

        public EventManager(int[][] events) {
            this.events = new HashMap<>();
            pq = new PriorityQueue<>(Comparator.comparingInt(Event::priority).reversed().thenComparingInt(Event::id));
            for (int[] e : events) {
                this.events.put(e[0], e[1]);
                pq.offer(new Event(e[0], e[1]));
            }
        }

        public void updatePriority(int eventId, int newPriority) {
            if (events.containsKey(eventId)) {
                if (events.get(eventId) == newPriority)
                    return;
                events.put(eventId, newPriority);
                pq.offer(new Event(eventId, newPriority));
            }
        }

        public int pollHighest() {
            while (!pq.isEmpty()) {
                Event e = pq.poll();
                if (!events.containsKey(e.id) || events.get(e.id) != e.priority)
                    continue;
                events.remove(e.id);
                return e.id;
            }
            return -1;
        }
    }
}
