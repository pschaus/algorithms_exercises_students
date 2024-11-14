package searching;


/**
 * A Bitset is an efficient alternative to using a Hashset
 * when you need to store a dense set of integers.
 * Instead of using an array of boolean to represent
 * the inclusion or exclusion of the value at the corresponding index,
 * it uses an array of long (called words) to store bits.
 * Each word encode 64 individual bits.
 *
 * Your task is to implement:
 * 1. The initialization of the Bitset,
 *      calculating the required number of long words to store the specified number of bits.
 * 2. The `getNbWords()` method should return the total number of long words used.
 * 3. Helper methods to set, clear, and count bits within the Bitset.
 *
 * Example:
 * Suppose we create a Bitset with a capacity of 8 bits,
 * with each "word" storing up to 4 bits (for simplicity in illustration).
 * The Bitset would initially be represented internally as [0000, 0000]. The following operations would yield:
 *  - getNbWords() : Returns 2 (total number of long words used).
 *  - set(4)       : Updates state to [0000, 0001] (sets the first bit in the second word).
 *  - set(2)       : Updates state to [0100, 0001] (sets the third bit in the first word).
 *  - set(7)       : Updates state to [0100, 1001] (sets the fourth bit in the second word).
 *  - count()      : Returns 3 (total number of bits set).
 *  - contains(2)  : Returns true.
 *  - clear(4)     : Updates state to [0100, 1000] (clears the first bit in the second word).
 */
public class Bitset {


    /**
     * Instantiate a new bitset able to hold n elements
     * @param n the number of bits to store
     */
    public Bitset(int n) {
        // TODO
    }

    /**
     *
     * @return the number of words used to store the n bits
     */
    public int getNbWords() {
        // TODO
         return 0;
    }


    /**
     * Set the ith bit
     * @param i the bit to set
     */
    public void set(int i) {
        // TODO
    }

    /**
     * Clear the ith bit
     * @param i the bit to clear
     */
    public void clear(int i) {
        // TODO
    }

    /**
     * Check if the ith bit is set in the structure
     * @param i the bit to check
     * @return true if the bit is set and false otherwise.
     */
    public boolean contains(int i) {
        // TODO
         return false;
    }

    /**
     * Returns the number of bits set in the structure
     * @return the total number of set bits
     */
    public int count() {
        // TODO
         return 0;
    }

}
