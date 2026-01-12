package util;

import easy.Solution434;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Source;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogTrickTest {

    private static LogTrick solution;

    @BeforeAll
    public static void setup() {
        solution = new LogTrick();
    }

    @Test
    void logTrick() {

        List<int[]> ans = solution.logTrick(new int[]{1, 2, 3, 3, 2, 2}, (a, b) -> a & b);

        for (int[] a : ans) {
            System.out.println("and value: " + a[0] + " left: " + a[1] + " right: " + a[2]);
        }

    }
}