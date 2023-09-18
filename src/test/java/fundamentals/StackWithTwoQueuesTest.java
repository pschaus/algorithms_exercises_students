package fundamentals;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class StackWithTwoQueuesTest {

    @Test
    @Grade(value=1)
    @Order(0)
    public void simpleTest(){
        StackWithTwoQueues<Integer> stack = new StackWithTwoQueues<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertFalse(stack.empty());
        for (int i = 9; i >= 0; i--) {
            assertEquals(i, (int) stack.pop());
        }
        assertTrue(stack.empty());
    }

}
