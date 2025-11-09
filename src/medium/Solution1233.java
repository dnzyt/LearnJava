package medium;

// 1233. Remove Sub-Folders from the Filesystem

import java.util.*;

public class Solution1233 {
    class Node {
        public Node[] children;
        public boolean isFolder;
        public Set<String> names;

        public Node() {
            children = new Node[26];
            isFolder = false;
            names = new HashSet<>();
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        Node root = new Node();
        List<String> ans = new ArrayList<>();
        for (String f : folder) {
            String[] paths = f.split("/");
            Node curr = root;
            boolean isSubFolder = false;
            for (String path : paths) {
                if (path.isEmpty()) continue;
                for (char c : path.toCharArray()) {
                    if (curr.children[c - 'a'] == null)
                        curr.children[c - 'a'] = new Node();
                    curr = curr.children[c - 'a'];
                }
                if (curr.isFolder && curr.names.contains(path)) {
                    isSubFolder = true;
                    break;
                }
                curr.names.add(path);
            }
            if (isSubFolder)
                continue;
            curr.isFolder = true;
            ans.add(f);
        }
        return ans;
    }
}
