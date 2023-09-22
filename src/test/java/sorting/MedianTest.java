package sorting;

import org.javagrader.Grade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import java.util.Arrays;

@Grade
public class MedianTest {

    private final Random random = new Random(635654);

    public static int [] randomInput(int size, Random r) {
        int [] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = r.nextInt(size);
        }
        return input;
    }

    public static Median.Vector vectorFromInput(int [] input) {
        Median.Vector v = new Median.Vector(input.length);
        for (int i = 0; i < input.length; i++) {
            v.set(i, input[i]);
        }
        return v;
    }

    public static int getMedian(int [] input) {
        int [] copy = new int[input.length];
        System.arraycopy(input, 0, copy, 0, input.length);
        Arrays.sort(copy);
        return copy[copy.length/2];
    }

    @Test
    @Grade(value = 1)
    public void testMedianOk() {
        for (int i = 100; i < 1000; i += 10) {
            int [] input = randomInput(i+1, random);
            Median.Vector v = vectorFromInput(input);
            assertEquals(getMedian(input), Median.median(v, 0, v.size() - 1));
        }
    }

}
