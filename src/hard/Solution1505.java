package hard;

// 1505. Minimum Possible Integer After at Most K Adjacent Swaps On Digits

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1505 {

    public String minInteger(String num, int k) {
        int n = num.length();
        int[] next = new int[10];
        int[] offset = new int[10];
        boolean[] removed = new boolean[n];
        Arrays.fill(next, -1);
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            if (next[digit] == -1)
                next[digit] = i;
        }
        StringBuilder sb = new StringBuilder();
        boolean finished = false;
        for (int i = 0; i < n; i++) {
            if (finished)
                break;
            for (int j = 0; j < 10; j++) {
                if (next[j] != -1) {
                    int d = next[j] + offset[j] - i;
                    if (d <= k) {
                        k -= d;
                        sb.append((char) (j + '0'));
                        removed[next[j]] = true;
                        if (k == 0) {
                            finished = true;
                            break;
                        }
                        for (int u = 0; u < 10; u++) {
                            if (next[u] < next[j])
                                offset[u]++;
                        }
                        boolean foundNext = false;
                        for (int pos = next[j] + 1; pos < n; pos++) {
                            if (removed[pos]) {
                                offset[j]--;
                            } else if (num.charAt(pos) == (char) (j + '0')) {
                                next[j] = pos;
                                foundNext = true;
                                break;
                            }
                        }
                        if (!foundNext)
                            next[j] = -1;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!removed[i])
                sb.append(num.charAt(i));
        }
        return sb.toString();
    }


    class FenwickTree {
        private int[] tree;

        public FenwickTree(int n) {
            tree = new int[n];
        }

        public void update(int i, int delta) {
            while (i < tree.length) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int ans = 0;
            while (i > 0) {
                ans += tree[i];
                i -= lowbit(i);
            }
            return ans;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }

    // 树状数组解法，快速求出一个区间内被删除的元素个数
    // 一个元素要移动，一定是移动到数组原始开头的前面，可以想像成往0位置的前一个位置插入数据，
    // 之前被移动到前面的元素都往左移动一位，所以每个元素移动的次数=元素的索引-此索引前被删除的元素个数
    public String minInteger2(String num, int k) {
        int n = num.length();
        FenwickTree f = new FenwickTree(n + 1);
        Deque<Integer>[] positions = new Deque[10];
        Arrays.setAll(positions, i -> new ArrayDeque<>());
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            positions[digit].add(i);
        }
        StringBuilder sb = new StringBuilder();
        boolean[] removed = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int digit = 0; digit < 10; digit++) {
                if (!positions[digit].isEmpty()) {
                    int pos = positions[digit].peek();
                    int miss = f.query(pos);
                    if (pos - miss <= k) {
                        k -= (pos - miss);
                        sb.append((char) (digit + '0'));
                        removed[pos] = true;
                        positions[digit].poll();
                        f.update(pos + 1, 1);
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
