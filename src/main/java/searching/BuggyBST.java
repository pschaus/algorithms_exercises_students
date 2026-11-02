package searching;

/**
 * Repair a binary search tree in which at most one node has an incorrect integer key.
 * The repair may change at most one key, but must leave every node and child link in place.
 * After the repair, the keys must satisfy the strict BST ordering property
 * (equivalently, an in-order traversal must produce strictly increasing keys).
 *
 * A detailed video explanations is available here: https://youtu.be/15pRnqHv7F4
 *
 * <p>See {@code BuggyBSTTest} for examples.
 */
public class BuggyBST {

    /**
     * Restores the strict BST ordering property by changing at most one key.
     *
     * @param root the non-null root of a tree containing at most one incorrect key
     */
    public static void fix(Node root) {
        // TODO (you may ask inner classes, additional methods, etc.)
    }


}

/**
 * Node class represents a single node in the binary search tree, with key, value, left and right children,
 * to keep track of the number of nodes in the subtree rooted at this node.
 * Do not change this class.
 */
class Node {
    int key;
    Node left, right;

    /**
     * Constructs a new Node with the specified key, and size.
     *
     * @param key The key of the node.
     */
    public Node(Integer key) {
        this.key = key;
    }
}
