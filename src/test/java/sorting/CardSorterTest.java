package sorting;

import org.javagrader.Grade;
import org.javagrader.CustomGradingResult;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.*;

@Grade
public class CardSorterTest {


    @Test
    public void testExample() {
        LinkedListImpl l = new LinkedListImpl(new int[]{7, 8, 2, 22, 102, 1});
        CardSorter.sort(l);
        assertTrue(l.isSorted());
    }

}


