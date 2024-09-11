package graphs;

import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.javagrader.TestResultStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Grade
public class EvacuationTest {



    @Test
    @Grade(value = 1)
    @GradeFeedback(message="Your algorithm does not return the correct result on the given example. Debug it locally", on=TestResultStatus.FAIL)
    public void testSimpleUniWeights1() {
        //  0 -- 1 -- 2 -- 4
        //       \   /
        //        \ /
        //         3
        int[][] graph = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}
        };

        int[] exits1 = {0, 3};
        int[] result1 = Evacuation.findShortestPaths(graph, exits1);
        assertTrue(Arrays.equals(new int[]{-1, 0, 3, -1, 2}, result1) ||
                Arrays.equals(new int[]{-1, 3, 3, -1, 2}, result1));

        int[] exits2 = {0, 4};
        int[] result2 = Evacuation.findShortestPaths(graph, exits2);
        assertTrue(Arrays.equals(new int[]{-1, 0, 4, 1, -1}, result2) ||
                Arrays.equals(new int[]{-1, 0, 4, 2, -1}, result2));

        int[] exits3 = {3};
        int[] result3 = Evacuation.findShortestPaths(graph, exits3);
        assertArrayEquals(new int[]{1, 3, 3, -1, 2}, result3);

    }

    @Test
    @Grade(value = 1)
    @GradeFeedback(message="Your algorithm does not return the correct result on the given example. Debug it locally", on=TestResultStatus.FAIL)
    public void testSimpleUniWeights2() {
        // 3 -- 4
        // | \  |
        // |  \ |
        // 1    2
        //  \  /
        //   0
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0}
        };

        int[] exits1 = {2};
        int[] result1 = Evacuation.findShortestPaths(graph, exits1);
        assertTrue(Arrays.equals(new int[]{2, 0, -1, 2, 2}, result1) ||
                Arrays.equals(new int[]{2, 3, -1, 2, 2}, result1));

        int[] exits2 = {3};
        int[] result2 = Evacuation.findShortestPaths(graph, exits2);
        assertTrue(Arrays.equals(new int[]{1, 3, 3, -1, 3}, result2) ||
                Arrays.equals(new int[]{2, 3, 3, -1, 3}, result2));

        int[] exits3 = {0,2};
        int[] result3 = Evacuation.findShortestPaths(graph, exits3);
        assertArrayEquals(new int[]{-1, 0, -1, 2, 2}, result3);
    }

    @Test
    @Grade(value = 1)
    @GradeFeedback(message="Your algorithm does not return the correct result on the given example. Debug it locally", on=TestResultStatus.FAIL)
    public void testSimpleVariousWeights3() {
        // 0 -- 1-- 4
        // |      /
        // 2    /
        // |   /
        // | /
        // 3

        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 8},
                {0, 1, 0, 8, 0}
        };

        int[] exits1 = {4};
        int[] result1 = Evacuation.findShortestPaths(graph, exits1);
        assertArrayEquals(new int[]{1, 4, 0, 2, -1}, result1);

    }

    @Test
    @Grade(value = 1)
    @GradeFeedback(message="Your algorithm does not return the correct result on the given example. Debug it locally", on=TestResultStatus.FAIL)
    public void testSimpleVariousWeights1() {
        //  0 -- 1 -- 2 -- 4
        //       \   /
        //        \ /
        //         3
        int[][] graph = {
                {0, 20, 0, 0, 0},
                {20, 0, 1, 1, 0},
                {0, 1, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}
        };

        int[] exits1 = {0, 3};
        int[] result1 = Evacuation.findShortestPaths(graph, exits1);
        assertArrayEquals(new int[]{-1, 3, 3, -1, 2}, result1);

        int[] exits2 = {0, 4};
        int[] result2 = Evacuation.findShortestPaths(graph, exits2);
        assertArrayEquals(new int[]{-1, 2, 4, 2, -1}, result2);

        int[] exits3 = {3};
        int[] result3 = Evacuation.findShortestPaths(graph, exits3);
        assertArrayEquals(new int[]{1, 3, 3, -1, 2}, result3);
    }


    @Test
    @Grade(value = 1)
    @GradeFeedback(message="Your algorithm does not return the correct result on the given example. Debug it locally", on=TestResultStatus.FAIL)
    public void testSimpleVariousWeights2() {
        // 0 -- 1 -- 2 -- 3 -- 4 -- 5 -- 6
        int[][] graph = {
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 2, 0, 0, 0, 0},
                {0, 2, 0, 2, 0, 0, 0},
                {0, 0, 2, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 3, 0},
                {0, 0, 0, 0, 3, 0, 3},
                {0, 0, 0, 0, 0, 3, 0}
        };
        int[] exits1 = {0, 6};
        int[] result1 = Evacuation.findShortestPaths(graph, exits1);
        assertTrue(Arrays.equals(new int[]{-1, 0, 1, 2, 3, 6, -1}, result1) ||
                Arrays.equals(new int[]{-1, 0, 1, 2, 5, 6, -1}, result1));
    }

    @Test
    @Grade(value = 1)
    @GradeFeedback(message="Your algorithm does not return the correct result on the given example. Debug it locally", on=TestResultStatus.FAIL)
    public void testNonConnectedGraph() {
        // 0 -- 1      3 -- 4
        // |   /       |    |
        // | /         |    |
        // 2           5 -- 6
        int[][] graph = {
                {0, 1, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 0}
        };
        int[] exits1 = {0, 3};
        int[] result1 = Evacuation.findShortestPaths(graph, exits1);
        assertTrue(Arrays.equals(new int[]{-1, 0, 0, -1, 3, 3, 4}, result1) ||
                Arrays.equals(new int[]{-1, 0, 0, -1, 3, 3, 5}, result1));

        int[] exits2 = {2, 3, 4};
        int[] result2 = Evacuation.findShortestPaths(graph, exits2);
        assertArrayEquals(new int[]{2, 2, -1, -1, -1, 3, 4}, result2);
    }


}
