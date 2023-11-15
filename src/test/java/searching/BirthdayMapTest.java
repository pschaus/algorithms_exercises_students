package searching;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.List;


@Grade
@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BirthdayMapTest {

    
    @Test
    @Grade(value = 1)
    @Order(0)
    public void testSimple() {
        BirthdayMap birthdayMap = new BirthdayMap();

        Person alice = new Person("Alice", "2000-07-17");
        Person bob = new Person("Bob", "2000-08-15");
        Person charlie = new Person("Charlie", "2001-06-06");

        birthdayMap.addPerson(alice);
        birthdayMap.addPerson(bob);
        birthdayMap.addPerson(charlie);

        List<Person> peopleBornIn2000 = birthdayMap.getPeopleBornInYear("2000");

        assertTrue(peopleBornIn2000.contains(alice));
        assertTrue(peopleBornIn2000.contains(bob));
        assertFalse(peopleBornIn2000.contains(charlie));
    }


    

}
