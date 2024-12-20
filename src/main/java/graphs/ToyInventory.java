package graphs;


/**
 * Santa’s workshop is buzzing with activity, but there’s trouble in the toy inventory department! The elves in charge
 * of managing the stock have lost their counts for the total inventory and the crucial list linking each toy to its
 * category.
 *
 * Santa is determined to have an accurate count of his toys, so he’s asked you to help recreate the inventory based on
 * what the elves can provide you.
 *
 * Here’s what the elves remember:
 *     1. The older elves provide you a list of pairs of toys that are in the same category.
 *     2. Each warehouse managers provides a list of the toys they have in stock, along with the number of each toy.
 *
 * Now, Santa has a list of specific toys he wants to check, and for each, you must determine the total number of toys
 * in its category. Can you help the elves restore the inventory and answer Santa’s requests?
 *
 * Input:
 *     * A list of pairs of strings, where each pair (x, y) indicates that toys x and y belong to the same category.
 *     * A list of toys in the warehouses
 *     * A list of the count for each toy in the warehouses
 *     * A list of toys Santa wants to query.
 *
 * Output:
 *     * A list of integers where the i-th value represents the total count of toys in the category of the i-th queried
 *       toy. If a toy belongs to no category or is not in stock, the count should be 0.
 *
 * For example:
 *     * Input: relations = [[piano, flute], [flute, xylophone], [car, helicopter]],
 *              occurrences_name = [piano, flute, piano, xylophone, car, helicopter],
 *              occurrences_count = [3, 2, 1, 5, 2, 3],
 *              requests = [piano, flute, helicopter, teddybear]
 *     * Output: [11, 11, 5, 0] -> total_count({piano, flute, xylophone}) = 3 + 2 + 1 + 5 = 11;
 *                                 total_count({car, helicopter}) = 2 + 3 = 5;
 *                                 total_count({teddy bear}) = 0;
 *
 * Expected Time-Complexity: O(N * log(N)) (N being the number of relations).
 *
 * Hint:
 *     * The problem involves grouping objects that are in the same family and summing their counts efficiently.
 *       A Union-Find data structure allows to identify and merge such groups of object efficiently.
 */
public class ToyInventory {

    /**
     * Computes for each requested toy the total number of toys stored in the warehouses that belong to the same
     * category.
     *
     * @param relations A list of pairs of strings, where each pair (x, y) indicates that toys x and y belong to the
     *                  same category.
     * @param occurrencesName A list of toys in the warehouses
     * @param occurrencesCount A list of the count for each toy in the warehouses
     * @param requests A list of toys Santa wants to query.
     *
     * @return A list of integers where the i-th value represents the total count of toys in the category of the i-th
     *         requested toy. If a toy belongs to no category or is not in stock, the count should be 0.
     */
    public static int[] answerRequests(String[][] relations, String[] occurrencesName, int[] occurrencesCount, String[] requests) {
        // TODO
         return null;
    }
}
