package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FenwickTreeTest {

    private FenwickTree fw;

    @Test
    void kth() {
        fw = new FenwickTree(10);

        // 插入一些数：5, 1, 3, 7, 3, 2
        fw.update(5, 1);
        fw.update(1, 1);
        fw.update(3, 1);
        fw.update(7, 1);
        fw.update(3, 1);
        fw.update(2, 1);

        // 1 2 3 3 5 7
        System.out.println("1st smallest: " + fw.kth(1));
        System.out.println("2nd smallest: " + fw.kth(2));
        System.out.println("3rd smallest: " + fw.kth(3));
        System.out.println("4th smallest: " + fw.kth(4));
        System.out.println("5th smallest: " + fw.kth(5));
        System.out.println("6th smallest: " + fw.kth(6));


    }
}