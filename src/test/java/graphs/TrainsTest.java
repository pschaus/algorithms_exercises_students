package graphs;

import org.javagrader.Grade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import graphs.Trains.*;

@Grade
public class TrainsTest {

    HashMap<StationTime, LinkedList<StationTime>> simpleExample1() {
        HashMap<StationTime, LinkedList<StationTime>> relations = new HashMap<>();
        
        relations.put(new StationTime("Bxl-midi", 10), new LinkedList<>(Arrays.asList(
                new StationTime("Bruges", 20),
                new StationTime("Ostende", 25),
                new StationTime("Blankenberg", 26),
                new StationTime("Namur", 12)
        )));

        relations.put(new StationTime("Bruges", 12), new LinkedList<>(Arrays.asList(
                new StationTime("Ostende", 14),
                new StationTime("Blankenberg", 16),
                new StationTime("Namur", 30)
        )));

        relations.put(new StationTime("Namur", 13), new LinkedList<>(Arrays.asList(
                new StationTime("Paris", 28),
                new StationTime("Charleroi", 16)
        )));

        relations.put(new StationTime("Namur", 15), new LinkedList<>(Arrays.asList(
                new StationTime("Paris", 26),
                new StationTime("Charleroi", 16)
        )));

        return relations;
    }

    
    private boolean containsElements(Set<String> container, String ... elements) {
        for (String element : elements) {
            if (!container.contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Test
    @Grade(value=4)
    public void exampleTest() {
        Map<String, Integer> out = Trains.reachableEarliest(simpleExample1(), new StationTime("Bxl-midi", 5));
        assertEquals(7, out.size());
        assertTrue(containsElements(out.keySet(),
                "Ostende",
                "Charleroi",
                "Blankenberg",
                "Bxl-midi",
                "Bruges",
                "Paris",
                "Namur"
        ));
        assertEquals(out.get("Ostende"), (Integer)25);
        assertEquals(out.get("Charleroi"), (Integer)16);
        assertEquals(out.get("Blankenberg"), (Integer)26);
        assertEquals(out.get("Bxl-midi"), (Integer)5);
        assertEquals(out.get("Bruges"), (Integer)20);
        assertEquals(out.get("Paris"), (Integer)26);
        assertEquals(out.get("Namur"), (Integer)12);
    }

    @Test
    @Grade(value=3)
    public void example2Test() {
        Map<String, Integer> out = Trains.reachableEarliest(simpleExample1(), new StationTime("Bruges", 5));
        assertEquals(4, out.size());
        assertTrue(containsElements(out.keySet(),
                "Ostende",
                "Blankenberg",
                "Bruges",
                "Namur"
        ));
        assertEquals(out.get("Ostende"), (Integer)14);
        assertEquals(out.get("Blankenberg"), (Integer)16);
        assertEquals(out.get("Bruges"), (Integer)5);
        assertEquals(out.get("Namur"), (Integer)30);
    }

}
