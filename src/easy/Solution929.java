package easy;

// 929. Unique Email Addresses

import java.util.HashSet;
import java.util.Set;

public class Solution929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> s = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0].split("\\+")[0];
            local = local.replace(".", "");
            s.add(local + "@" + parts[1]);
        }
        return s.size();
    }
}
