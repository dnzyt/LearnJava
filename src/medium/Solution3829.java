package medium;

// 3829. Design Ride Sharing System

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution3829 {
    class RideSharingSystem {

        private Deque<Integer> riders;
        private Deque<Integer> drivers;
        private Set<Integer> currentRiders;

        public RideSharingSystem() {
            riders = new ArrayDeque<>();
            drivers = new ArrayDeque<>();
            currentRiders = new HashSet<>();
        }

        public void addRider(int riderId) {
            riders.offer(riderId);
            currentRiders.add(riderId);
        }

        public void addDriver(int driverId) {
            drivers.offer(driverId);
        }

        public int[] matchDriverWithRider() {
            if (riders.size() == 0 || drivers.size() == 0)
                return new int[]{-1, -1};

            while (riders.size() > 0 && !currentRiders.contains(riders.peek()))
                riders.poll();
            if (riders.size() == 0)
                return new int[]{-1, -1};
            return new int[]{drivers.poll(), riders.poll()};
        }

        public void cancelRider(int riderId) {
            if (currentRiders.contains(riderId))
                currentRiders.remove(riderId);
        }
    }
}
