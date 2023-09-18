package graphs;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class MineClimbingTest {

    @Test
    @Grade(value = 5.0, cpuTimeout = 3000)
    @Order(1)
    public void simpleTest() {
        int[][] map = new int[][]{
                {7, 2, 9, 6},
                {8, 7, 6, 0},
                {4, 6, 5, 8}
        };

        assertEquals(8, MineClimbing.best_distance(map, 0, 1, 2, 3));
    }

    @Test
    @Grade(value = 4.0, cpuTimeout = 3000)
    @Order(1)
    public void almostFlatMapTest() {
        int[][] map = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        assertEquals(1, MineClimbing.best_distance(map, 1, 1, 4, 4));
    }


    @Test
    @Grade(value = 4.0, cpuTimeout = 3000)
    @Order(1)
    public void borderTest() {
        int[][] map = new int[][]{
                {9, 9, 1, 9, 2},
                {9, 1, 2, 9, 1},
                {1, 2, 9, 9, 2},
                {9, 9, 2, 1, 9},
                {2, 1, 9, 9, 1}
        };

        assertEquals(10, MineClimbing.best_distance(map, 0, 2, 4, 1));
    }

    @Test
    @Grade(value = 4.0, cpuTimeout = 3000)
    @Order(1)
    public void stepsTest() {
        int[][] map = new int[][]{
                {6, 5, 4, 3, 4, 5, 6},
                {5, 4, 3, 2, 3, 4, 5},
                {4, 3, 2, 1, 2, 3, 4},
                {3, 2, 1, 0, 1, 2, 3},
                {4, 3, 2, 1, 2, 3, 4},
                {5, 4, 3, 2, 3, 4, 5},
                {6, 5, 4, 3, 4, 5, 6},
        };

        assertEquals(6, MineClimbing.best_distance(map, 3, 3, 0, 0));
    }

    @Test
    @Grade(value = 4.0, cpuTimeout = 3000)
    @Order(1)
    public void increasingCostTest() {
        int[][] map = new int[][]{
                {46, -40, 30, -22, 31, -41, 47},
                {-39, 29, -14, 9, -15, 32, -42},
                {28, -13, 5, -2, 6, -16, 33},
                {-21, 12, -5, 1, -3, 10, -23},
                {27, -20, 8, -4, 7, -17, 34},
                {-38, 26, -19, 11, -18, 35, -43},
                {45, -37, 25, -24, 36, -44, 48},
        };

        assertEquals(221, MineClimbing.best_distance(map, 3, 3, 0, 0));
    }


}
