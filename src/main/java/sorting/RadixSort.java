package sorting;

/**
 * Radix sort implementation.
 * Complete the code to pass the test on positive numbers.
 * You can assume that all numbers are non-negative as a first step.
 *
 * As a second step, adapt the code to handle negative numbers.
 * You can also add tests for negative numbers.
 * Remind that negative numbers use the two's complement representation.
 * For example, the number -3 is represented in 4 bits as follows:
 *    1. Positive binary representation of 3: 0011
 *    2. Invert the bits: 1100
 *    3. Add 1: 1100 + 0001 = 1101
 * Thus, -3 in 4-bit two's complement is represented as 1101.
 *
 * What is the time complexity of your algorithm?
 * How does it compare in practice to the other sorting algorithms?
 *
 * @author Pierre Schaus and Harold Kiossous
 */
public class RadixSort {

    // Radix Sort method (we assume all numbers are non-negative)
    public static void sort(int[] A) {
        int maxBits = getMaxBits(A);
        int [] aux = new int[A.length];
        for (int i = 0; i < maxBits; i++) {
            stableSortOnBit(A, i, aux);
        }
    }


    /**
     * Stable Sort the array A based on the i-th bit
     * In order to have the best time complexity, your algorithm should run in O(n)
     * where n is the size of the array A.
     * @param A the array to sort based on the i-th bit
     * @param bitPosition
     * @param aux is an auxiliary array of the same size as A that you can use in your algorithm
     */
    private static void stableSortOnBit(int[] A, int bitPosition, int[] aux) {
        // TODO
    }

    // Helper method to get the bit at the given position
    private static int getBit(int number, int bitPosition) {
        return (number >> bitPosition) & 1;
    }

    // Helper Method to find the maximum number of bits required
    private static int getMaxBits(int[] A) {
        int max = 0;
        for (int num : A) {
            max = Math.max(max, num);
        }
        return 32 - Integer.numberOfLeadingZeros(max);
    }

}