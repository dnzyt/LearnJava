package medium;

// 3484. Design Spreadsheet

import java.util.HashMap;
import java.util.Map;

public class Solution3484 {
    class Spreadsheet {
        private Map<String, Integer> data;

        public Spreadsheet(int rows) {
            data = new HashMap<>();
        }

        public void setCell(String cell, int value) {
            data.put(cell, value);
        }

        public void resetCell(String cell) {
            data.remove(cell);
        }

        public int getValue(String formula) {
            int ans = 0;
            for (String cell : formula.substring(1).split("\\+")) {
                if (Character.isUpperCase(cell.charAt(0))) {
                    ans += data.getOrDefault(cell, 0);
                } else
                    ans += Integer.parseInt(cell);
            }
            return ans;
        }
    }
}
