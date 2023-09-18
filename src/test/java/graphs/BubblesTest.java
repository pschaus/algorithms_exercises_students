package graphs;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.*;

@Grade
@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BubblesTest {

    private final Random random = new Random(90208);
    
    @Grade(value = 1)
    @Order(1)
    @Test
    public void exampleTest() {
        List<Contact> contacts = Collections.unmodifiableList(Arrays.asList(
                new Contact("Alice", "Bob"),
                new Contact("Alice", "Carole"),
                new Contact("Carole", "Alice"),
                new Contact("Eve", "Alice"),
                new Contact("Alice", "Frank"),
                new Contact("Bob", "Carole"),
                new Contact("Bob", "Eve"),
                new Contact("Bob", "Frank"),
                new Contact("Bob", "Carole"),
                new Contact("Bob", "Eve"),
                new Contact("Bob", "Frank"),
                new Contact("Bob", "Carole"),
                new Contact("Eve", "Frank")
        ));
        List<ForbiddenRelation> fr = Bubbles.cleanBubbles(contacts, 3);
        assertEquals(fr.size(), 1);
        assertEquals(fr.get(0), new ForbiddenRelation("Alice", "Bob"));
    }

    @Test
    @Grade(value = 1)
    @Order(2)
    public void example2Test() {
        List<Contact> contacts = Collections.unmodifiableList(Arrays.asList(
                new Contact("Alice", "Bob"),
                new Contact("Alice", "Carole"),
                new Contact("Carole", "Alice"),
                new Contact("Eve", "Alice"),
                new Contact("Alice", "Frank"),
                new Contact("Bob", "Carole"),
                new Contact("Bob", "Eve"),
                new Contact("Bob", "Frank"),
                new Contact("Bob", "Carole"),
                new Contact("Bob", "Eve"),
                new Contact("Bob", "Frank"),
                new Contact("Bob", "Carole"),
                new Contact("Eve", "Frank")
        ));
        List<ForbiddenRelation> fr = Bubbles.cleanBubbles(contacts, 2);
        Collections.sort(fr);
        assertEquals(fr.size(), 3);
    }


}
