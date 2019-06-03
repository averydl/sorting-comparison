public class BubbleSort implements Sort {
    private Comparable[] arr;
    public BubbleSort(Comparable[] arr) {
        this.arr = arr;
    }
    /*
     * implements sort using
     * the bubble sort algorithm
     */
    @Override
    public void sort() {
        boolean swap = true;
        // swap any unordered adjacent elements until all elements are ordered
        while (swap == true) {
            swap = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap = true;
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}
