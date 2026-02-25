package util;

import easy.Solution434;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SparseTableTest {

    private static SparseTable st;

    @BeforeAll
    public static void setup() {
        st = new SparseTable(new int[]{
                2, 4, 8, 9, 2, 7, 4, 1, 9, 11, 32, 3, 16, 21
        });
    }

    @Test
    void query() {
        int x = st.query(2, 8);
        assertEquals(9, x);
        x = st.query(0, 12);
        assertEquals(32, x);
        x = st.query(4, 9);
        assertEquals(11, x);
    }

}