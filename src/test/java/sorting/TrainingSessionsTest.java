package sorting;


import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.javagrader.TestResultStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Grade
public class TrainingSessionsTest {

    @Test
    @Grade(value = 1)
    @GradeFeedback(message="Your algorithm does not return the correct result on the given example. Debug it locally", on=TestResultStatus.FAIL)
    public void testSimple1() {
        TrainingSessions scheduler = new TrainingSessions();
        int[][] sessions = {
                {9, 12},//          ---
                {3, 6}, //    ---
                {1, 4}, //  ---
                {2, 5}, //   ---
                {7, 8}, //        -
        };
        // three intervals are overlapping at time 3: [1, 4), [2, 5), [3, 6)
        assertEquals(3, scheduler.minFacilitiesRequired(sessions));
    }

    @Test
    @Grade(value = 1)
    @GradeFeedback(message="Your algorithm does not return the correct result on the given example. Debug it locally", on=TestResultStatus.FAIL)
    public void testSimple2() {
        TrainingSessions scheduler = new TrainingSessions();
        int[][] sessions = {
                {1, 4},   //  ---
                {4, 10},   //    ------
                {1, 10}    // ---------
        };
        // two intervals are overlapping everywhere on {1,10} in this example
        assertEquals(2, scheduler.minFacilitiesRequired(sessions));
    }

}
