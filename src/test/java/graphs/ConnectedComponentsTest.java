package graphs;

import com.github.guillaumederval.javagrading.Grade;
import org.junit.Test;
import utils.Graph;

import java.util.Random;

import static org.junit.Assert.assertEquals;


public class ConnectedComponentsTest {

    @Test
    public void exampleTest() {
        int n = 9;
        Graph g = new Graph(n);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(4, 7);
        g.addEdge(6, 8);
        assertEquals(3, ConnectedComponents.numberOfConnectedComponents(g));
    }

}
