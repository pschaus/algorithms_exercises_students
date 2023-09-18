package fundamentals;

import org.javagrader.Grade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Grade
public class StackTest {


    @Grade
    @Test
    public void testSimpleStack() {

        Stack<Integer> [] stacks = new Stack[2];
        stacks[0] = new ArrayStack<>();
        stacks[1] = new LinkedStack<>();
        for (Stack<Integer> stack : stacks) {
            stack.push(1);
            assertEquals(1, stack.peek());
            stack.push(2);
            stack.push(3);
            assertFalse(stack.empty());
            assertEquals(3, (int) stack.pop());
            assertEquals(2, (int) stack.pop());
            assertEquals(1, (int) stack.pop());
            assertTrue(stack.empty());

        }
    }

}

