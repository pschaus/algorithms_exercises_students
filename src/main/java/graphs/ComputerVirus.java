package graphs;

import java.util.*;

/**
 * Proposed at the exam of August 2025
 * A computer virus has infected a computer network.
 * Each node represents a server, and edges represent directed connections to other servers.
 * The virus starts at a given server (the “start server”) at time 0.
 * Each server takes a specific incubation time before it becomes infectious to adjacent servers.
 * Once a server becomes infectious, it immediately begins infecting its direct neighbors via outgoing edges.
 *
 * Your task is to compute and return the earliest time each server becomes infectious.
 *
 * The time complexity of your solution should be O(n + m log n)
 */
public class ComputerVirus {


    /**
     * Computes the earliest time each server in the network becomes infectious.
     *
     * @param network a map representing the directed connections between servers
     * @param incubation a map representing the incubation time for each server
     * @param start the server where the virus starts
     * @return a map with the earliest time each server becomes infectious,
     *         if a server is not reachable, it should not be included in the result
     */
    public static Map<String, Integer> computeInfectionTimes(
            Map<String, List<String>> network,
            Map<String, Integer> incubation,
            String start
    ) {
         return null;
    }
}
