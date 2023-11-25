import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(3);
        s.add(3);
        s.add(4);
        s.add(4);
        s.add(4);
        s.add(4);
        int idx = Collections.binarySearch(s, 3);

        System.out.println(idx);
//        System.out.println("complement: " + (~idx));

    }
}