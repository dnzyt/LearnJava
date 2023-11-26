import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        int[] a = new int[] {0, 0, 0, 0};
        Integer[] b = new Integer[2];
        IntStream intStream = Arrays.stream(a);
        List<Integer> collect = intStream.boxed().toList();
        System.out.println(idx);
//        System.out.println("complement: " + (~idx));


    }
}