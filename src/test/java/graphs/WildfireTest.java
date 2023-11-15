package graphs;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Random;



@Grade
@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WildfireTest {

    static final int EMPTY = 0;
    static final int TREE = 1;
    static final int BURNING = 2;

    
    @Test
    @Grade(value = 1)
    @Order(0)
    public void testSimple() {
        Wildfire wildfire = new Wildfire();

        int[][] forest1 = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        // The first forest has a burning tree right in the middle, and all trees are reachable,
        // so the fire should reach all trees in 4 time units (corners of the forest).
        assertEquals(4, wildfire.burnForest(forest1));

        int[][] forest2 = {
                {1, 1, 1, 0, 1},
                {1, 2, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1}
        };
        // The second forest has all trees are reachable, but it will require 8 time units for the fire to reach the further tree in the top right corner.
        assertEquals(8, wildfire.burnForest(forest2));

        int[][] forest3 = {
                {1, 0, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 2, 1, 1, 1}
        };
        // The third forest has a burning tree, but there are trees that the fire can't reach (the top-right) because of the empty spaces, so it should return -1.
        assertEquals(-1, wildfire.burnForest(forest3));

        int[][] forest4 = {
                {1, 1, 0, 2, 1},
                {1, 0, 0, 0, 1},
                {2, 1, 0, 0, 1},
                {1, 2, 0, 1, 2}
        };
        // The fourth forest has four burning tree, two in each part.
        // all the trees are reachable within three units of time.
        assertEquals(3, wildfire.burnForest(forest4));

    }


    

}
