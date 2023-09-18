package searching;

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


import java.util.TreeSet;

@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class BinarySearchTreeTest {


    @Test
    @Grade(value=1, cpuTimeout = 1000)
    @GradeFeedback(message="Sorry, something is wrong with your algorithm. Debug first on this small example")
    @Order(1)
    public void  testExample() {
        TreeSet<Integer> correct = new java.util.TreeSet<>();
        int [] values = new int []{12, 8, 18, 3, 11, 14, 20, 9, 15};
        int [] inputs = new int []{11, 14, 9, 4, 16, 10, 19, 21, 30, 40};

        BinarySearchTree.BSTNode<Integer> root = new BinarySearchTree.BSTNode<>(values[0]);
        correct.add(values[0]);
        for (int i = 0; i < values.length; i++) {
            root.add(values[i]);
            correct.add(values[i]);
        }

        for (int i: inputs) {
            assertEquals(correct.ceiling(i), BinarySearchTree.ceil(root, i));
        }
    }
    
}
