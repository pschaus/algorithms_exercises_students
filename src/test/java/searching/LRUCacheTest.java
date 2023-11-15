package searching;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;



@Grade
@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LRUCacheTest {


    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    @Order(0)
    @GradeFeedback(message = "Sorry, something is wrong with your algorithm, debug first this small example")
    public void testDebug() {

        LRUCache<Character, Integer> cache = new LRUCache<>(3);
        //  Example of an LRU cache with capacity of 3:
        // step 0:
        cache.put('A',7);  // map{(A,7)}  A is the LRU
        // step 1:
        cache.put('B',10); // map{(A,7),(B,10)}  A is the LRU
        // step 2:
        cache.put('C',5);  // map{(A,7),(B,10),(C,5)}  A is the LRU
        // step 3:
        cache.put('D',8);  // map{(B,10),(C,5),(D,8)}  A is suppressed, B is the LRU
        // step 4:
        assertNull(cache.get('A'));
        assertEquals(Integer.valueOf(10),cache.get('B'));    // C is the LRU
        // step 5
        cache.put('E',9);  // map{(B,10),(D,8),(E,9)} D is the LRU
        assertNull(cache.get('C'));
        // step 6
        cache.put('D',3);  // map{(B,10),(D,3),(E,9)} B is the LRU

        // step 7
        cache.get('B');    // map{(B,10),(D,3),(E,9)} E is the LRU
        // step 8
        cache.put('A',2);  // map{(B,10),(D,3),(A,2)} D is the LRU
        assertNull(cache.get('E'));
        assertNull(cache.get('C'));
        assertEquals(Integer.valueOf(2),cache.get('A'));
        assertEquals(Integer.valueOf(3),cache.get('D'));
        assertEquals(Integer.valueOf(10),cache.get('B'));
    }

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    @Order(0)
    @GradeFeedback(message = "Sorry, something is wrong with your algorithm, debug first this small example")
    public void secondDebugTest() {
        LRUCache<Integer, String> cache = new LRUCache<>(4);
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.put(4, "d");
        cache.put(5, "e");
        cache.get(2);
        cache.put(6, "f");
        assertNull(cache.get(1));
        assertEquals("b", cache.get(2));
        assertNull(cache.get(3));
        assertEquals("d", cache.get(4));
        assertEquals("e", cache.get(5));
        assertEquals("f", cache.get(6));
    }



}
