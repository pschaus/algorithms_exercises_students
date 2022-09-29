package searching;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradingRunnerWithParametersFactory;
import org.junit.runners.Parameterized;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.TreeSet;

@RunWith(Enclosed.class)
public class BinarySearchTreeTest {

    public static class TestNotParameterized {

        @Test
        @Grade(value=1, cpuTimeout = 1000)
        @GradeFeedback(message="Sorry, something is wrong with your algorithm. Debug first on this small example", onFail=true)
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

}
