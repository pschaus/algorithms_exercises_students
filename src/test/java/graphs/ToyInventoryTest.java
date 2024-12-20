package graphs;

import org.javagrader.Grade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;



@Grade
public class ToyInventoryTest {

    @Test
    @Grade(value = 1)
    public void testSimple() {
        String[][] relations = new String[3][2];
        relations[0][0] = "piano";
        relations[0][1] = "flute";
        relations[1][0] = "flute";
        relations[1][1] = "xylophone";
        relations[2][0] = "car";
        relations[2][1] = "helicopter";
        String[] occurrences_name = new String[]{"piano", "flute", "piano", "xylophone", "car", "helicopter"};
        int[] occurrences_count = new int[]{3, 2, 1, 5, 2, 3};
        String[] requests = new String[]{"piano", "flute", "helicopter", "teddybear"};
        int[] results = ToyInventory.answerRequests(relations, occurrences_name, occurrences_count, requests);
        assertArrayEquals(new int[]{11, 11, 5, 0}, results);
    }

}
