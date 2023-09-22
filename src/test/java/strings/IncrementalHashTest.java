package strings;

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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class IncrementalHashTest {

    @Test
    @Grade(value = 1)
    @GradeFeedback(message = "Sorry, something is wrong with your algorithm, debug it first with this small example with M=2")
    public void readableTestToDebugWithLength2() {

        char [] input = new char[] {5,6,7,8,9,10};
        int Q = 10;
        int M = 2;
        int R = IncrementalHash.R;

        IncrementalHash hash = new IncrementalHash(Q, M);

        int [] expectedHash = new int[input.length-M];
        for (int from = 0; from < input.length-M ; from++) {
            expectedHash[from] = (input[from] * R + input[from+1]) % Q; // here M = 2, don't need a loop for that
        }

        int h = expectedHash[0]; // first hash (at from = 0)

        for (int i = 1; i < input.length-M;i++) {
            h = hash.nextHash(input,h,i);
            assertEquals(expectedHash[i], h);
        }
    }

    @Test
    @Grade(value = 1)
    @GradeFeedback(message = "Sorry, something is wrong with your algorithm, debug it first with this small example with M=3")
    public void readableTestToDebugWithLength3() {

        char [] input = new char[] {10,9,8,7,6,5};
        int Q = 20;
        int M = 3;
        int R = IncrementalHash.R;

        IncrementalHash hash = new IncrementalHash(Q, M);

        int [] expectedHash = new int[input.length-M];
        for (int from = 0; from < input.length-M ; from++) {
            expectedHash[from] = (input[from] * R * R + input[from+1] * R + input[from+2]) % Q; // here M = 3, don't need a loop for that
        }

        int h = expectedHash[0]; // first hash (at from = 0)

        for (int i = 1; i < input.length-M;i++) {
            h = hash.nextHash(input,h,i);
            assertEquals(expectedHash[i], h);
        }
    }


}
