public class InsertionSort implements Sort {
    private Comparable[] arr;
    public InsertionSort(Comparable[] arr) {
        this.arr = arr;
    }
    /*
     * implements sort using the
     * insertion sort algorithm
     */
    @Override
    public void sort() {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0 && less(arr[j], arr[j-1]); j--) {
                swap(arr, j, j-1);
            }
        }
    }

    @Override
    public String toString() {
        return "Insertion Sort";
    }
}
