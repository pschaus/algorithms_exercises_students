package graphs;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
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
public class BreadthFirstShortestPathsTest {


    @Test
    @Grade(value = 20)
    @Order(1)
    public void testSimple() {
        BreadthFirstShortestPaths.Graph graph = new BreadthFirstShortestPaths.Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);

        BreadthFirstShortestPaths bfs = new BreadthFirstShortestPaths(graph, Arrays.asList(1));

        assertEquals(0, bfs.distTo(1));
        assertEquals(1, bfs.distTo(0));
        assertEquals(2, bfs.distTo(2));
        assertEquals(2, bfs.distTo(3));
        assertEquals(2, bfs.distTo(4));
    }

    @Test
    @Grade(value = 20)
    @GradeFeedback(message="Test [0-1, 1-2, 3-4] with [1] as sources")
    @Order(2)
    public void testDisconnected() {
        BreadthFirstShortestPaths.Graph graph = new BreadthFirstShortestPaths.Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        BreadthFirstShortestPaths bfs = new BreadthFirstShortestPaths(graph, Arrays.asList(1));
        assertEquals(1, bfs.distTo(0));
        assertEquals(1, bfs.distTo(2));

        assertEquals(Integer.MAX_VALUE, bfs.distTo(3));
        assertEquals(Integer.MAX_VALUE, bfs.distTo(4));
    }

    @Test
    @Grade(value = 20)
    @GradeFeedback(message="Test [0-1, 1-2, 2-3, 3-4, 4-5, 5-0] with [0] as sources")
    @Order(3)
    public void testLoop() {
        BreadthFirstShortestPaths.Graph graph = new BreadthFirstShortestPaths.Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 0);

        BreadthFirstShortestPaths bfs = new BreadthFirstShortestPaths(graph, Arrays.asList(0));
        assertEquals(0, bfs.distTo(0));
        assertEquals(1, bfs.distTo(1));
        assertEquals(2, bfs.distTo(2));
        assertEquals(3, bfs.distTo(3));
        assertEquals(2, bfs.distTo(4));
        assertEquals(1, bfs.distTo(5));
    }

    @Test
    @Grade(value = 20)
    @GradeFeedback(message="Test [0-1, 1-2, 2-3, 3-4, 4-5] with [1, 5] as sources")
    @Order(4)
    public void testMultipleSources() {
        BreadthFirstShortestPaths.Graph graph = new BreadthFirstShortestPaths.Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        BreadthFirstShortestPaths bfs = new BreadthFirstShortestPaths(graph, Arrays.asList(1, 5));
        assertEquals(1, bfs.distTo(0));
        assertEquals(0, bfs.distTo(1));
        assertEquals(1, bfs.distTo(2));
        assertEquals(2, bfs.distTo(3));
        assertEquals(1, bfs.distTo(4));
        assertEquals(0, bfs.distTo(5));
    }

    @Test
    @Grade(value = 20)
    @GradeFeedback(message="Test [0-1, 1-2, 3-4, 4-5] with [0, 2] as sources")
    @Order(5)
    public void testMultipleSourcesDisconnected1() {
        BreadthFirstShortestPaths.Graph graph = new BreadthFirstShortestPaths.Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        BreadthFirstShortestPaths bfs = new BreadthFirstShortestPaths(graph, Arrays.asList(0, 2));
        assertEquals(0, bfs.distTo(0));
        assertEquals(1, bfs.distTo(1));
        assertEquals(0, bfs.distTo(2));
        assertEquals(Integer.MAX_VALUE, bfs.distTo(3));
        assertEquals(Integer.MAX_VALUE, bfs.distTo(4));
        assertEquals(Integer.MAX_VALUE, bfs.distTo(5));
    }


    @Test
    @Grade(value = 20)
    @GradeFeedback(message="Test [0-1, 1-2, 3-4, 4-5] with [0, 3] as sources")
    @Order(5)
    public void testMultipleSourcesDisconnected2() {
        BreadthFirstShortestPaths.Graph graph = new BreadthFirstShortestPaths.Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        BreadthFirstShortestPaths bfs = new BreadthFirstShortestPaths(graph, Arrays.asList(0, 3));
        assertEquals(0, bfs.distTo(0));
        assertEquals(1, bfs.distTo(1));
        assertEquals(2, bfs.distTo(2));
        assertEquals(0, bfs.distTo(3));
        assertEquals(1, bfs.distTo(4));
        assertEquals(2, bfs.distTo(5));
    }

}


