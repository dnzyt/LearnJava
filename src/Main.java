import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer total = list.stream().reduce(2, Integer::sum);
        Integer i = list.stream().min(Integer::compareTo).orElseThrow();
        System.out.println(i);
    }
}