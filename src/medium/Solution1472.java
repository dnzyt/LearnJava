package medium;

// 1472. Design Browser History

import java.util.ArrayList;
import java.util.List;

public class Solution1472 {
    class BrowserHistory {
        private int idx;
        private List<String> history;

        public BrowserHistory(String homepage) {
            this.history = new ArrayList<String>();
            this.history.add(homepage);
            this.idx = 0;
        }

        public void visit(String url) {
            while (this.idx + 1 != this.history.size()) {
                this.history.remove(this.history.size() - 1);
            }
            this.history.add(url);
            this.idx++;

        }

        public String back(int steps) {
            if (this.idx < steps) {
                this.idx = 0;
            } else {
                this.idx -= steps;
            }
            return this.history.get(this.idx);
        }

        public String forward(int steps) {
            if (this.idx + steps >= this.history.size()) {
                this.idx = this.history.size() - 1;
            } else {
                this.idx += steps;
            }
            return this.history.get(this.idx);
        }
    }
}
