package searching;

import org.javagrader.Grade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;






@Grade
public class SleighRankingTest {

    @Test
    @Grade(value = 1)
    public void testSimple() {
        int[] rankings = SleighRanking.computeRankings(new int[]{5, 4, 6, 4, 2, 3, 7});
        assertArrayEquals(new int[]{0, 0, 2, 0, 0, 1, 6}, rankings);
    }

}
