package sorting;

import org.javagrader.Grade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

@Grade
public class DroneContestTest {
    private static Drone[] copyAndShuffle(Drone[] in, Random r) {
        Drone[] out = Arrays.copyOf(in, in.length);
        Collections.shuffle(Arrays.asList(out), r);
        return out;
    }


    @Test
    @Grade(value = 2, cpuTimeout = 1000)
    public void example() { // only one!
        Drone[] participants = new Drone[7];
        participants[0] = new Drone(1, 5, 3);
        participants[1] = new Drone(3, 12, 5);
        participants[2] = new Drone(6, 14, 1);
        participants[3] = new Drone(7, 15, 4);
        participants[4] = new Drone(15, 18, 5);
        participants[5] = new Drone(16, 20, 1);
        participants[6] = new Drone(17, 19, 2);

        LinkedList<HeightChange> changes = DroneContest.findHighest(participants);


        int[] correctTime = new int[]{0, 1, 3, 12, 15, 18, 19, 20};
        int[] correctHeight = new int[]{0, 3, 5, 4, 5, 2, 1, 0};

        assertEquals(correctTime.length, changes.size());
        for(int i = 0; i < correctTime.length; i++) {
            assertEquals(correctTime[i], changes.get(i).time);
            assertEquals(correctHeight[i], changes.get(i).height);
        }
    }
}
