package graphs;

import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


import java.util.*;

@Grade
public class DigraphTest {

    @Test
    @Grade(value = 1)
    public void simpleTest(){
        Digraph graph = new Digraph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        Digraph reverse = graph.reverse();
        assertEquals(6, graph.V());
        assertEquals(4, graph.E());
        assertEquals(6, reverse.V());
        assertEquals(4, reverse.E());
        assertEqualsIterable(Arrays.asList(1), graph.adj(0));
        assertEqualsIterable(Arrays.asList(2), graph.adj(1));
        assertEqualsIterable(Arrays.asList(), graph.adj(2));
        assertEqualsIterable(Arrays.asList(4), graph.adj(3));
        assertEqualsIterable(Arrays.asList(5), graph.adj(4));
        assertEqualsIterable(Arrays.asList(), graph.adj(5));
        assertEqualsIterable(Arrays.asList(), reverse.adj(0));
        assertEqualsIterable(Arrays.asList(0), reverse.adj(1));
        assertEqualsIterable(Arrays.asList(1), reverse.adj(2));
        assertEqualsIterable(Arrays.asList(), reverse.adj(3));
        assertEqualsIterable(Arrays.asList(3), reverse.adj(4));
        assertEqualsIterable(Arrays.asList(4), reverse.adj(5));
    }

    public void assertEqualsIterable(Iterable<Integer> one, Iterable<Integer> two) {
        ArrayList<Integer> oneList = new ArrayList<>();
        for (int i : one) {
            oneList.add(i);
        }
        ArrayList<Integer> twoList = new ArrayList<>();
        for (int i : two) {
            twoList.add(i);
        }
        Integer[] oneArray = oneList.toArray(new Integer[0]);
        Arrays.sort(oneArray);
        Integer[] twoArray = twoList.toArray(new Integer[0]);
        Arrays.sort(twoArray);
        assertArrayEquals(oneArray, twoArray);
    }

}
