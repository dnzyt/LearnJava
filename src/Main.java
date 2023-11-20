import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = Arrays.stream(a,2, 4).toArray();
        int[] d = Arrays.copyOfRange(a, 2, 4);
        int s = Arrays.stream(a).sum();
        double avg = Arrays.stream(a).average().orElse(1.0);
        for (int c: d)
            System.out.println(c);
    }
}