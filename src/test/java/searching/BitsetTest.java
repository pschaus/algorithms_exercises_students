package searching;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.javagrader.TestResultStatus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;


@Grade
@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BitsetTest {


    @Test
    @Grade(value = 1)
    @GradeFeedback(message = "Your implementation fails to effectively represents the given data. Test on a small example", on = TestResultStatus.FAIL)
    @Order(1)
    public void testSimple() {

        Bitset bitset = new Bitset(30);

        // Bitset Initial Values
        assertEquals(1, bitset.getNbWords());
        assertEquals(0, bitset.count());

        // Set First bit
        bitset.set(0);
        assertTrue(bitset.contains(0));
        // Set the last bit
        bitset.set(29);
        assertTrue(bitset.contains(29));

        // All the others bits are clear
        for (int i = 1; i < 29; i++) {
            assertFalse(bitset.contains(i));
        }

        // Compute the count of bits set
        assertEquals(2, bitset.count());

        // Clear the first bit
        bitset.clear(0);
        assertEquals(1, bitset.count());

        // Clear the last bit
        bitset.clear(29);
        assertEquals(0, bitset.count());
    }



}
