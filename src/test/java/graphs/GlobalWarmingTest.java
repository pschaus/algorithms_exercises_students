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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class GlobalWarmingTest {

    @Test
    @Grade(value=1, cpuTimeout = 1000)
    @GradeFeedback(message="Sorry, something is wrong with your algorithm. Debug first on this small example")
    @Order(1)
    public void  testExample() {
        int [][] altitude = new int[][] {{1, 3, 3, 1, 3},
                                         {4, 2, 2, 4, 5},
                                         {4, 4, 1, 4, 2},
                                         {1, 4, 2, 3, 6},
                                         {1, 1, 1, 6, 3}};
        int waterLevel = 3;

        GlobalWarming globalWarming = new GlobalWarming(altitude, waterLevel);
        assertEquals(4, globalWarming.nbIslands());
        GlobalWarming.Point p1 = new GlobalWarming.Point(1, 0);
        GlobalWarming.Point p2 = new GlobalWarming.Point(3, 1);
        GlobalWarming.Point p3 = new GlobalWarming.Point(1, 3);
        GlobalWarming.Point p4 = new GlobalWarming.Point(0, 0);
        assertTrue(globalWarming.onSameIsland(p1, p2));
        assertFalse(globalWarming.onSameIsland(p1, p3));
        assertFalse(globalWarming.onSameIsland(p1, p4));
    }

}
