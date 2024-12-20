package sorting;

import org.javagrader.Grade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;


@Grade
public class PancakeSortingTest {

    private static void flip(int[] array, int to) {
        for (int i = 0; i < (to + 1) / 2; i++) {
            int t = array[i];
            array[i] = array[to - i];
            array[to - i] = t;
        }
    }

    @Test
    @Grade(value=1)
    public void testSimple() {
        int[] input = new int[]{3, 1, 2, 5, 4};
        int[] flips = PancakeSorting.sort(Arrays.copyOf(input, input.length));
        assertTrue(flips.length <= 3 * input.length);
        for (int flip : flips) {
            assertTrue(flip >= 0 && flip < input.length);
            flip(input, flip);
        }
        for (int i = 0; i < input.length - 1; i++) {
            assertTrue(input[i] <= input[i + 1]);
        }
    }

}
