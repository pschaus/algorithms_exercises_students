package sorting;

import com.github.guillaumederval.javagrading.Grade;
import org.junit.Test;
import sorting.Union;

import java.util.*;

import static org.junit.Assert.*;

public class UnionTest {


    @Test
    @Grade(value = 25)
    public void testUnits() {

        Union.Interval i1 = new Union.Interval(1, 3);
        Union.Interval i2 = new Union.Interval(1, 3);
        Union.Interval[] result = Union.union(new Union.Interval[]{i1, i2});
        assertArrayEquals(result, new Union.Interval[]{new Union.Interval(1, 3)});

        i1 = new Union.Interval(1, 3);
        i2 = new Union.Interval(2, 4);
        result = Union.union(new Union.Interval[]{i1, i2});
        assertArrayEquals(result, new Union.Interval[]{new Union.Interval(1, 4)});

        i1 = new Union.Interval(1, 2);
        i2 = new Union.Interval(2, 4);
        result = Union.union(new Union.Interval[]{i1, i2});
        assertArrayEquals(result, new Union.Interval[]{new Union.Interval(1, 4)});

        i1 = new Union.Interval(1, 2);
        i2 = new Union.Interval(3, 4);
        result = Union.union(new Union.Interval[]{i1, i2});
        assertArrayEquals(result, new Union.Interval[]{new Union.Interval(1, 2), new Union.Interval(3, 4)});


        i1 = new Union.Interval(1, 2);
        i2 = new Union.Interval(2, 2);
        result = Union.union(new Union.Interval[]{i1, i2});
        assertArrayEquals(result, new Union.Interval[]{new Union.Interval(1, 2)});

        i1 = new Union.Interval(1, 1);
        i2 = new Union.Interval(2, 2);
        result = Union.union(new Union.Interval[]{i1, i2});
        assertArrayEquals(result, new Union.Interval[]{new Union.Interval(1, 1), new Union.Interval(2, 2)});

        Union.Interval i0 = new Union.Interval(7, 9);
        i1 = new Union.Interval(5, 8);
        i2 = new Union.Interval(2, 4);
        result = Union.union(new Union.Interval[]{i0, i1, i2});
        assertArrayEquals(result, new Union.Interval[]{new Union.Interval(2, 4), new Union.Interval(5, 9)});


        i0 = new Union.Interval(10, 10);
        i1 = new Union.Interval(2, 4);
        i2 = new Union.Interval(3, 4);
        Union.Interval i3 = new Union.Interval(5, 6);
        Union.Interval i4 = new Union.Interval(6, 9);
        Union.Interval i5 = new Union.Interval(6, 8);
        result = Union.union(new Union.Interval[]{i0, i1, i2, i3, i4, i5});
        assertArrayEquals(result, new Union.Interval[]{new Union.Interval(2, 4), new Union.Interval(5, 9), new Union.Interval(10, 10)});
    }

    public static Union.Interval randomInterval(Random rand) {
        int min = rand.nextInt(20);
        return new Union.Interval(min, min + rand.nextInt(4));
    }

}
