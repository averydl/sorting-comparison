public interface Sort {
    // sorts the array of Comparables
    void sort();

    // swaps Comparables at indices @param i1 and @param i2
    default void swap(Comparable[] arr, int i1, int i2) {
        Comparable swap = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = swap;
    }

    // returns true if @param c1 is less-than @param c2
    default boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }
}