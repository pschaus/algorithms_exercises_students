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
public class GalaxyPathTest {

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    @GradeFeedback(message = "Sorry, something is wrong with your algorithm, debug first this small with five galaxies")
    @Order(1)
    public void readableTestToDebug() {
        // Hint: feel free to duplicate and modify this test for your needs

        int[][] matrix = new int[5][5];

        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[1][3] = 3;
        matrix[2][4] = 1;
        matrix[3][4] = 3;

        HashSet<Integer> dest = new HashSet<>();
        dest.add(4);

        // The path 0->2->4 is not possible because when it arrives at 2,
        // the current time is 1 (duration for travelling through a by-pass) and the by-pass 2->4 is closed.
        // Therefore the only feasible path to reach the destination is 0 -> 1 -> 3 -> 4 (length of 3 expected)
        int len = GalaxyPath.findPath(matrix, 0, dest);
        assertEquals(3, len);

        // If we now set the delay for closing the by-pass 2->4 to 2, then the path 0 -> 2 -> 4 becomes feasible (length of 2 expected)
        matrix[2][4] = 2;
        len = GalaxyPath.findPath(matrix, 0, dest);
        assertEquals(2, len);
    }


}
