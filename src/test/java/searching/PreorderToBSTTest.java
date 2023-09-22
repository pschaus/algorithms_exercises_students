package searching;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class PreorderToBSTTest {


    @Test
    @Grade(value=1, cpuTimeout = 1000)
    @GradeFeedback(message="Sorry, something is wrong with your algorithm. Debug first on this small example")
    @Order(1)
    public void testSimple() {
        int[] preOrderInput = {10,5,7,14,12};
        PreorderToBST student = new PreorderToBST(preOrderInput);
        PreorderToBST teacher = new PreorderToBST();
        teacher.root = new PreorderToBST.Node(new PreorderToBST.Node(null, new PreorderToBST.Node(null, null, 7), 5), new PreorderToBST.Node(new PreorderToBST.Node(null, null, 12), null, 14), 10);
        assertEquals(teacher, student);

    }

}
