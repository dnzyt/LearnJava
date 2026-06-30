package medium;

// 2353. Design a Food Rating System

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2353 {
    class FoodRatings {

        record FoodRating(String name, String cuisin, int rating) implements Comparable<FoodRating> {
            @Override
            public int compareTo(FoodRating o) {
                if (this.rating == o.rating)
                    return this.name.compareTo(o.name);
                return o.rating - this.rating;
            }
        }

        private Map<String, FoodRating> fr;
        private Map<String, PriorityQueue<FoodRating>> cs;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            fr = new HashMap<>();
            cs = new HashMap<>();
            int n = foods.length;
            for (int i = 0; i < n; i++) {
                String name = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];
                FoodRating x = new FoodRating(name, cuisine, rating);
                fr.put(name, x);
                cs.computeIfAbsent(cuisine, c -> new PriorityQueue<>()).offer(x);
            }
        }

        public void changeRating(String food, int newRating) {
            FoodRating old = fr.get(food);
            FoodRating x = new FoodRating(food, old.cuisin, newRating);
            fr.put(food, x);
            cs.get(old.cuisin).offer(x);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<FoodRating> pq = cs.get(cuisine);
            while (true) {
                FoodRating top = pq.poll();
                if (fr.get(top.name).rating != top.rating)
                    pq.offer(new FoodRating(top.name, top.cuisin, fr.get(top.name).rating));
                else {
                    pq.offer(top);
                    break;
                }
            }
            return pq.peek().name;
        }
    }
}

/*
 * ["kimchi","miso",     "sushi",   "moussaka","ramen",   "bulgogi"]
 * ["korean","japanese", "japanese","greek",   "japanese","korean"]
 *   9,       12,         8,         15,        14,        7
 *
 *
 *
 *
 * */