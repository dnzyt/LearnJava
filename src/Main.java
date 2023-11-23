import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(4);
        s.push(2);
        for (int i = 0; i < s.size(); i++)
            System.out.println(s.get(i));
    }
}