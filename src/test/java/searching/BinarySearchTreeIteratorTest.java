package searching;

import searching.BinarySearchTreeIterator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradingRunnerWithParametersFactory;
import org.junit.runners.Parameterized;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Iterator;

@RunWith(Enclosed.class)
public class BinarySearchTreeIteratorTest {

    public static class TestNotParameterized {
        @Test
        @Grade(value=1, cpuTimeout = 1000)
        @GradeFeedback(message="Sorry, something is wrong with your algorithm. Debug first on this small example", onFail=true)
        public void  testExample() {
            BinarySearchTreeIterator<Integer> tree = new BinarySearchTreeIterator<>();
            int [] values = new int []{12, 8, 18, 3, 11, 14, 20, 9, 15};
            for (int v : values) {
                tree.put(v);
            }
            Integer [] output = new Integer []{3, 8, 9, 11, 12, 14, 15, 18, 20};

            Iterator<Integer> iter = tree.iterator();
            for (int i = 0; i < output.length; i++) {
                assertTrue(iter.hasNext());
                assertEquals(output[i], iter.next());
            }
            assertTrue(!iter.hasNext());
        }

    }

