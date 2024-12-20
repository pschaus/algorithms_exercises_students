package graphs;

import org.javagrader.Grade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.HashSet;
import java.util.Arrays;


@Grade
public class CriticalPathwaysTest {

    private static void sortResult(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            Arrays.sort(result[i]);
        }
        Arrays.sort(result, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
    }

    @Test
    @Grade(value = 1)
    public void testSimple() {
        HashSet<Integer>[] adj = new HashSet[6];
        for (int i = 0; i < 6; i++) {
            adj[i] = new HashSet<>();
        }
        adj[0].add(1);
        adj[0].add(2);
        adj[1].add(0);
        adj[1].add(3);
        adj[1].add(2);
        adj[2].add(0);
        adj[2].add(1);
        adj[2].add(5);
        adj[3].add(1);
        adj[3].add(4);
        adj[4].add(3);
        adj[5].add(2);

        int[][] criticals = CriticalPathways.findCriticalPathways(adj);

        // Sort output
        sortResult(criticals);
        int[][] solution = {
                {1, 3},
                {2, 5},
                {3, 4}
        };
        assertArrayEquals(solution, criticals);
    }

}
