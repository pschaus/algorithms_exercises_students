package graphs;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import java.util.stream.IntStream;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class WordTransformationSPTest {

    @Grade
    @Order(0)
    @Test
    public void simpleTest() {
        String s = "abc";
        String d = "cba";
        assertEquals(3, WordTransformationSP.minimalCost(s, d));

        String s2 = "HAMBURGER";
        String d2 = "HAMBEGRUR";
        assertEquals(4, WordTransformationSP.minimalCost(s2, d2));

    }

}

