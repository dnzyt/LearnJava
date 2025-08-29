package medium;

// 306. Additive Number

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution306 {
    public boolean isAdditiveNumber(String num) {
        List<String> path = new ArrayList<>();
        return dfs(num, 0, path);
    }

    public boolean dfs(String s, int start, List<String> path) {
        if (start == s.length()) {
            return path.size() > 2;
        }
        int i = start + 1;
        while (i <= s.length()) {
            String sub = s.substring(start, i);
            if (sub.length() > 1 && sub.startsWith("0")) return false;
            if (path.size() < 2) {
                path.add(sub);
                if (dfs(s, i, path)) return true;
                path.remove(path.size() - 1);
            } else {
                String a = path.get(path.size() - 1);
                String b = path.get(path.size() - 2);
                if (add(a, b).equals(sub)) {
                    path.add(sub);
                    if (dfs(s, i, path)) return true;
                    path.remove(path.size() - 1);
                }
            }
            i ++;
        }
        return false;
    }

    private String add(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        reverseArray(a);
        reverseArray(b);

        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            int num = a[i] - '0' + b[i] - '0' + carry;
            ans.add(num % 10);
            carry = num / 10;
            i ++;
            j ++;
        }
        while (i < a.length) {
            int num = a[i] - '0' + carry;
            ans.add(num % 10);
            carry = num / 10;
            i ++;
        }
        while (j < b.length) {
            int num = b[j] - '0' + carry;
            ans.add(num % 10);
            carry = num / 10;
            j ++;
        }
        if (carry > 0) ans.add(carry);
        Collections.reverse(ans);
        StringBuilder sb = new StringBuilder();

        for (Integer num : ans) {
            sb.append(num);
        }
        return sb.toString();
    }

    private void reverseArray(char[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            char t = a[i];
            a[i] = a[j];
            a[j] = t;
            i ++;
            j --;
        }
    }


}
