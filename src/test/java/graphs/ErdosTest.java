package graphs;

import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.javagrader.TestResultStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Grade
public class ErdosTest {

	@Test
	@Grade(value = 0.75)
	@GradeFeedback(message="Your algorithm does not return the correct result on the given example. Debug it locally", on=TestResultStatus.FAIL)
	public void testSimple() {
		ArrayList<String []> authors = new ArrayList<>();
		authors.add(new String [] { "Paul Erdös", "Edsger W. Dijkstra" });
		authors.add(new String [] { "Edsger W. Dijkstra", "Alan M. Turing" });
		authors.add(new String [] { "Edsger W. Dijkstra", "Donald Knuth" });
		authors.add(new String [] { "Donald Knuth", "Stephen Cook", "Judea Pearl" });

		Erdos erdos = new Erdos(authors);
		assertEquals(0, erdos.findErdosNumber(Erdos.erdos));
		assertEquals(1, erdos.findErdosNumber("Edsger W. Dijkstra"));
		assertEquals(2, erdos.findErdosNumber("Alan M. Turing"));
		assertEquals(2, erdos.findErdosNumber("Donald Knuth"));
		assertEquals(3, erdos.findErdosNumber("Stephen Cook"));
		assertEquals(3, erdos.findErdosNumber("Judea Pearl"));
	}

}
