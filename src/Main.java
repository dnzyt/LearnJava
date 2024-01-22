import util.Bound;
import util.Eratosthenes;
import util.QuickPow;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        List<Integer> a = List.of(2, 5, 3, 8, 44, 52, 44, 2, 7);
//        2 2 3 5 7 8 44 44 52
//        0 1 2 3 4 5 6  7  8
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(5);
        a.add(3);
        a.add(8);
        a.add(44);
        a.add(52);
        a.add(44);
        a.add(2);
        a.add(7);
        Collections.sort(a);
        int low = Bound.lowerBound(a, 44);
        int up = Bound.upperBound(a, 1);
        System.out.println(up);
    }
}