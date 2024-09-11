package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * The erdos number is a "collaborative distance" metric to Paul Erdos (a prolific mathematician)
 * based on co-authorship of mathematical articles.
 * It is computed as follows:
 * - Erdos has, by definition an erdos-number of 0.
 * - For each other author, we look at all his/her co-authors in each article.
 *   If n is the minimum erdos-number from all his co-authors, then this author has an erdos-number of n+1.
 *
 * For example:
 *
 * Given this set of co-authors relations:
 *
 * 		{ "Paul Erdös", "Edsger W. Dijkstra" }
 * 		{ "Edsger W. Dijkstra", "Alan M. Turing" }
 * 		{ "Edsger W. Dijkstra", "Donald Knuth" }
 * 		{ "Donald Knuth", "Stephen Cook", "Judea Pearl" }
 *
 * 	The erdos number of Paul Erdos is 0, of Edsger W. Dijkstra is 1, of Alan M. Turing is 2, of Donald Knuth is 2, of Stephen Cook is 3.
 *
 * 	Debug your code on the small examples in the test suite.
 */
public class Erdos {

	public static final String erdos = "Paul Erdös";



	/**
	 * Constructs an Erdos object and computes the Erdős numbers for each author.
	 *
	 * The constructor should run in O(n*m^2) where n is the number of co-author relations,
	 * and m the maximum number of co-authors in one article.
	 *
	 * @param articlesAuthors An ArrayList of String arrays, where each array represents the list of authors of a single article.
	 */
	public Erdos(ArrayList<String []> articlesAuthors) {
		// TODO
	}

	/**
	 * Returns the Erdős number of a given author.
	 * This method is expected to run in O(1).
	 * @param author The name of the author whose Erdős number is to be found.
	 * @return The Erdős number of the specified author. If the author is not in the network, returns -1.
	 */
	public int findErdosNumber(String author) {
		// TODO
		 return -1;
	}

}
