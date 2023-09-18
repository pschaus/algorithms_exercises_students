package graphs;

//feel free to import anything here


/**
 * You just bought yourself the latest game from the Majong™
 * studio (recently acquired by Macrosoft™): MineClimb™.
 * In this 3D game, the map is made up of size 1
 * dimensional cube blocks, aligned on a grid,
 * forming vertical columns of cubes.
 * There are no holes in the columns, so the state
 * of the map can be represented as a matrix M of size n⋅m
 * where the entry M_{i,j} is the height of
 * the cube column located at i,j (0 ≤ i < n, 0 ≤ j < m).
 * You can't delete or add cubes, but you do have
 * climbing gear that allows you to move from one column to another
 * (in the usual four directions (north, south, east, west),
 * but not diagonally). The world of MineClimb™ is round:
 * the position north of (0,j) is (n-1,j), the position
 * west of (i,0) is (i,m-1) , and vice versa.
 * <p>
 * The time taken to climb up or down a column depends on
 * the difference in height between the current column and the next one.
 * Precisely, the time taken to go from column (i,j)
 * to column (k,l) is |M_{i,j}-M_{k,l}|
 * <p>
 * Given the map of the mine, an initial position
 * and an end position, what is the minimum time needed
 * to reach the end position from the initial position?
 */
public class MineClimbing {


    /**
     * Returns the minimum distance between (startX, startY) and (endX, endY), knowing that
     * you can climb from one mine block (a,b) to the other (c,d) with a cost Math.abs(map[a][b] - map[c][d])
     * <p>
     * Do not forget that the world is round: the position (map.length,i) is the same as (0, i), etc.
     * <p>
     * map is a matrix of size n times m, with n,m > 0.
     * <p>
     * 0 <= startX, endX < n
     * 0 <= startY, endY < m
     */
    public static int best_distance(int[][] map, int startX, int startY, int endX, int endY) {
        // TODO
         return 0;
    }
}
