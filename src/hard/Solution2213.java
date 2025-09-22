package hard;

// 2213. Longest Substring of One Repeating Character

public class Solution2213 {
    private int[] pre;
    private int[] suf;
    private int[] mx;
    private int n;
    private char[] s;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        n = s.length();
        int size = 2 << (32 - Integer.numberOfLeadingZeros(n));
        pre = new int[size];
        suf = new int[size];
        mx = new int[size];
        this.s = s.toCharArray();
        build(1, 0, n - 1);
        int[] ans = new int[queryCharacters.length()];
        for (int i = 0; i < queryCharacters.length(); i++) {
            int idx = queryIndices[i];
            this.s[idx] = queryCharacters.charAt(i);
            update(1, 0, n - 1, idx);
            ans[i] = mx[1];
        }

        return ans;
    }

    private void build(int root, int left, int right) {
        if (left == right) {
            pre[root] = suf[root] = mx[root] = 1;
            return;
        }
        int mid = (left + right) >>> 1;
        build(root * 2, left, mid);
        build(root * 2 + 1, mid + 1, right);
        maintain(root, left, right);
    }

    private void update(int root, int left, int right, int i) {
        if (left == right) return;
        int mid = (left + right) >>> 1;
        if (i <= mid)
            update(root * 2, left, mid, i);
        else
            update(root * 2 + 1, mid + 1, right, i);
        maintain(root, left, right);
    }

    private void maintain(int root, int left, int right) {
        pre[root] = pre[root * 2];
        suf[root] = suf[root * 2 + 1];
        mx[root] = Math.max(mx[root * 2], mx[root * 2 + 1]);
        int mid = (left + right) >>> 1;
        if (s[mid] == s[mid + 1]) {
            if (suf[root * 2] == mid - left + 1)
                pre[root] += pre[root * 2 + 1];
            if (pre[root * 2 + 1] == right - mid)
                suf[root] += suf[root * 2];
            mx[root] = Math.max(mx[root], suf[root * 2] + pre[root  * 2 + 1]);
        }
    }

}
