package graphs;

import java.util.HashSet;

/**
 * Santa’s sleigh relies on a magical communication network of relay stations and bidirectional magic pathways. This
 * network ensures seamless coordination between the North Pole and Santa's team during the Christmas gift deliveries.
 * However, the network is fragile: certain pathways are critical, and their removal could disrupt the entire system by
 * splitting the network into disconnected parts.
 *
 * Santa needs your help to identify all these critical pathways so that the elves can reinforce them before the big
 * night.
 *
 * Given the network of relay stations and pathways, determine all the critical pathways whose removal would increase
 * the number of connected components in the network. At the start, the network is composed of a single connected
 * component.
 *
 * Input:
 *     * A graph represented as an adjacency list. The adjacency list is stored as an array of HashSet where each set
 *       contains the ids of the nodes that are adjacent to the node.
 *
 * Output:
 *     * A list of pairs (u,v) representing the critical pathways in the network. Since the graph is undirected, each
 *       edge appears twice in the adjacency list. However, you only need to return each edge once.
 *
 * For example:
 *     * Input: adj = [
 *                        (1, 2),
 *                        (0, 2, 3),
 *                        (0, 1, 5),
 *                        (1, 4),
 *                        (3),
 *                        (2)
 *                    ]
 *     * Output: [(2, 5), (1, 3), (3, 4)]
 *     * Explanation:
 *
 *         adj represents the graph:
 *
 *                   2 ----- 5
 *                 /  \
 *               /     \
 *              0 ----- 1 ----- 3 ----- 4
 *
 *         In this graph if the edge (2, 5) is removed then some nodes (5) are not connected to the remaining of the
 *         graph. It is also the same for the edges (1, 3) and (3, 4).
 *
 * Expected Time-Complexity: O(N^3) (N being the number of nodes)
 *
 * Hint:
 *     * It would be inefficient to take into account all the edges in the graph. Since a spanning tree must cover all
 *       the nodes in a graph, every critical edge in the original graph will be part of any spanning tree. If we only
 *       consider these edges, deleting them one by one from the original graph could make it possible to determine
 *       which ones are critical.
 */
public class CriticalPathways {


    /**
     * Determines all the critical pathways whose removal would increase the number of components in the network.
     *
     * @param adj A graph represented as an adjacency list. The adjacency list is stored as an array of HashSet where
     *            each set contains the ids of the nodes that are adjacent to the node.
     *
     * @return A list of pairs (u,v) representing the critical pathways in the network. Since the graph is undirected,
     *         each edge appears twice in the adjacency list. However, you only need to return each edge once.
     */
    public static int[][] findCriticalPathways(HashSet<Integer>[] adj) {
        // TODO
         return null;
    }
}
