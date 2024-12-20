package searching;

import org.javagrader.Grade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Grade
public class CandiesBagTest {

    @Test
    @Grade(value = 1)
    public void testSimple1() {
        int maxLength = CandiesBag.findMaximumSize(new int[]{1, -1, 5, -2, 3}, 3);
        assertEquals(4, maxLength);
    }

    @Test
    @Grade(value = 1)
    public void testSimple2() {
        int maxLength = CandiesBag.findMaximumSize(new int[]{-2, -1, 2, 1}, 1);
        assertEquals(2, maxLength);
    }

}
