package graphs;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradingRunnerWithParametersFactory;
import org.junit.runners.Parameterized;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class GlobalWarmingTest {

    public static class TestNotParameterized {
        @Test
        @Grade(value=1, cpuTimeout = 1000)
        @GradeFeedback(message="Sorry, something is wrong with your algorithm. Debug first on this small example", onFail=true)
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

}
