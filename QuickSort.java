public class QuickSort implements Sort {
    private Comparable[] arr;
    public QuickSort(Comparable[] arr) {
        this.arr = arr;
    }

    /*
     * implements sort using
     * the quick sort algorithm
     */
    @Override
    public void sort() {
        quickSort(arr, 0, arr.length-1);
    }

    /*
     * recursive quicksort implementation which takes an array and
     * the first/last indices of the subarray being sorted as arguments
     */
    public void quickSort(Comparable[] arr, int first, int last) {
        if(last <= first) {
            return;
        }
        int pivot = partition(arr, first, last);
        quickSort(arr, first, pivot-1);
        quickSort(arr, pivot+1, last);
    }

    /*
     * private helper function used to partition comparables
     * in an array around a given pivot value in conjunction
     * with the quickSort() function
     */
    private int partition(Comparable[] a, int first, int last) {
        choosePivot(a, first, last); // choose pivot & place at @param first index
        int pivotIndex = first;
        Comparable pivot = a[first];
        int lastS1 = pivotIndex;
        int firstUnknown = pivotIndex + 1;
        for (; firstUnknown <= last; firstUnknown++)
        {
            if (less(a[firstUnknown], pivot))
            {
                lastS1++;
                swap(a, firstUnknown, lastS1);
            }
        }

        swap(a, pivotIndex, lastS1);
        pivotIndex = lastS1;
        return pivotIndex;
    }

    /*
     * private helper function to select a pivot (middle value
     * in a comparable array) and place it at the first index
     * of the array; to be used in conjunction with the
     * quickSort() function
     */
    private void choosePivot(Comparable[] arr, int first, int last) {
        int pivot = (first + last) / 2;
        swap(arr, first, pivot);
    }

    @Override
    public String toString() {
        return "Quick Sort";
    }
}