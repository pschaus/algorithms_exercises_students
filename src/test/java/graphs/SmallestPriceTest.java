package graphs;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;



@Grade
@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SmallestPriceTest {


    @Test
    @Order(0)
    @Grade(value = 1, cpuTimeout = 1000)
    public void smallGraph() {

        SmallestPrice.WeightedGraph graph = new SmallestPrice.WeightedGraph(6);
        graph.addEdge(new SmallestPrice.DirectedEdge(0, 1, 1));
        graph.addEdge(new SmallestPrice.DirectedEdge(0, 3, 2));
        graph.addEdge(new SmallestPrice.DirectedEdge(1, 2, 1));
        graph.addEdge(new SmallestPrice.DirectedEdge(3, 2, 1));
        graph.addEdge(new SmallestPrice.DirectedEdge(3, 4, 2));
        graph.addEdge(new SmallestPrice.DirectedEdge(2, 5, 4));
        graph.addEdge(new SmallestPrice.DirectedEdge(4, 5, 1));

        int source = 0;

        ArrayList<SmallestPrice.Pair> dests = new ArrayList<>();
        dests.add(new SmallestPrice.Pair(5, 40));
        dests.add(new SmallestPrice.Pair(4, 60));

        int[] costs = new int[]{3, 5, 4};
        int[] expectedPrices = new int[]{-1, 40, 60};

        for (int i = 0; i < costs.length; i++) {
            assertEquals(expectedPrices[i], SmallestPrice.getSmallestPrice(graph, source, costs[i], dests));
        }

    }

}
