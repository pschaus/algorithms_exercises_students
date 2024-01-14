package graphs;

import java.util.*;

/**
 * Author: Alexis Englebert
 * You are the chief operator of a new power plant in the new city of Louvain-La-Neuve.
 * Unfortunately, the engineers have not provided you with the plans for the city's electrical network.
 * All you know is the size of the electrical wires between each city.
 * You are well aware that the cost associated with the electrical wires is enormous.
 * Therefore, you want to minimize these costs throughout the entire electrical network. In a such way
 * that each city is connected by one wire.
 *
 *                                   ┌───────┐
 *                                   │       │
 *                                   │   1   │
 *                            ┌──────┤       ├─────┐
 *                            │      └───────┘     │
 *                       (5)  │                    │ (20)
 *                            │                    │
 *                            │                    │
 *                         ┌──┴────┐          ┌────┴──┐
 *                         │       │          │       │
 *                         │   2   ├──────────┤   3   │
 *                         │       │   (10)   │       │
 *                         └───────┘          └───────┘
 *
 * In the given network above the minimum cost is 15 (5 + 10)
 *
 */

public class Electricity {


    /**
     * @param network list of edges in the network
     */
    public Electricity(List<Edge> network) {
        //TODO

    }

    /**
     * Returns the minimum cost in the network
     * @returns minimum cost in the network
     */
    int getMinCost() {
        // TODO
         return -1;
    }

    static class Edge {
        int source;
        int dest;
        int weight;

        Edge(int s, int d, int w) {
            this.source = s;
            this.dest = d;
            this.weight = w ;
        }

    }

}
