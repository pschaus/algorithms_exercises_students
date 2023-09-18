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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



import java.util.*;
@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class MazeTest {

    public static int[][] maze1 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0}
    };

    public static int[][] maze2 = new int[][]{
            {0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0, 1, 0}
    };


    @Test
    @Grade(value = 1)
    @Order(1)
    public void testMaze1a() {
        Iterable<Integer> path = Maze.shortestPath(maze1, 0, 0, 6, 0);
        Integer[] pathArray = toArray(path);
        assertTrue(validPathSourceToDest(0, 0, 6, 0, maze1, path));
        assertEquals(15, pathArray.length);
    }

    @Test
    @Grade(value = 1)
    @Order(1)
    public void testMaze1b() {
        // should not have a path
        // unreachable destination
        assertFalse(Maze.shortestPath(maze1, 0, 0, 6, 6).iterator().hasNext());
        // unreachable destination
        assertFalse(Maze.shortestPath(maze1, 6, 6, 0, 0).iterator().hasNext());
        // start position is a wall
        assertFalse(Maze.shortestPath(maze1, 1, 0, 6, 0).iterator().hasNext());
        // end position is a wall
        assertFalse(Maze.shortestPath(maze1, 6, 0, 1, 0).iterator().hasNext());
    }

    @Test
    @Grade(value = 1)
    @Order(1)
    public void testMaze1c() {
        Iterable<Integer> path = Maze.shortestPath(maze1, 0, 0, 0, 0);
        Integer[] pathArray = toArray(path);
        assertTrue(validPathSourceToDest(0, 0, 0, 0, maze1, path));
        assertEquals(1, pathArray.length);
    }

    @Test
    @Grade(value = 1)
    @Order(1)
    public void testMaze2a() {
        Iterable<Integer> path = Maze.shortestPath(maze2, 0, 0, 1, 6);
        Integer[] pathArray = toArray(path);
        assertTrue(validPathSourceToDest(0, 0, 1, 6, maze2, path));
        assertEquals(10, pathArray.length);
    }


    public static boolean validPathSourceToDest(int x1, int y1, int x2, int y2, int[][] maze, Iterable<Integer> path) {
        int m = maze[0].length;
        Iterator<Integer> ite = path.iterator();
        if (!ite.hasNext()) return false;
        int p = ite.next();
        int x = row(p, m);
        int y = col(p, m);
        if (x != x1 || y != y1) return false;
        while (ite.hasNext()) {
            p = ite.next();
            int x_ = row(p, m);
            int y_ = col(p, m);
            if (maze[x][y] == 1) return false;
            if (Math.abs(x_ - x) + Math.abs(y_ - y) != 1) return false;
            x = x_;
            y = y_;
        }
        if (x != x2 || y != y2) return false;
        return true;
    }

    public static Integer[] toArray(Iterable<Integer> path) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        path.forEach(list::add);
        return list.toArray(new Integer[0]);
    }

    public static int row(int pos, int mCols) {
        return pos / mCols;
    }
    public static int col(int pos, int mCols) {
        return pos % mCols;
    }

}
