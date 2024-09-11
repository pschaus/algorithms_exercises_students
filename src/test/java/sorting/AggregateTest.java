package sorting;

import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Grade
public class AggregateTest {




    @Test
    @Grade(value = 1, cpuTimeout = 1)
    @GradeFeedback(message = "Simple Aggregate Test")
    public void testAggregateSimple() {
        int[][] arrayTest = {
                {1, 4, 6},
                {2, 1, 4},
                {2, 2, 4},
                {1, 4, 7},
                {3, 3, 5},
                {1, 5, 7}
        };

        int[][] outputRef0 = {
                {1, 4, 7},
                {2, 1, 4},
                {3, 3, 5}
        };

        int[][] outputRef1 = {
                {2, 1, 4},
                {2, 2, 4},
                {3, 3, 5},
                {1, 4, 6},
                {1, 5, 7}
        };

        int[][] outputRef2 = {
                {2, 1, 4},
                {3, 3, 5},
                {1, 4, 6},
                {1, 4, 7}
        };

        int[][] outputTest0 = Aggregate.aggregate(arrayTest, 0);
        assertArrayEquals(outputRef0, outputTest0);

        int[][] outputTest1 = Aggregate.aggregate(arrayTest, 1);
        assertArrayEquals(outputRef1, outputTest1);

        int[][] outputTest2 = Aggregate.aggregate(arrayTest, 2);
        assertArrayEquals(outputRef2, outputTest2);
    }


    @Test
    @Grade(value = 2, cpuTimeout = 1)
    @GradeFeedback(message = "Simple Mode Test")
    public void testModeSimple() {
        int[][] array = {
                {1, 5, 3},
                {4, 5, 2},
                {6, 2, 8},
                {9, 2, 2},
                {1, 5, 3}
        };
        assertEquals(2, Aggregate.mode(array, 1, 4, 1));
        assertEquals(5, Aggregate.mode(array, 0, 4, 1));
    }






}
