public class SelectionSort implements Sort {
    private Comparable[] arr;
    public SelectionSort(Comparable[] arr) {
        this.arr = arr;
    }
    /*
     * implements sort using
     * selection sort algorithm
     */
    @Override
    public void sort() {
        int min;
        for(int i = 0; i < arr.length; i++) {
            min = i;
            for(int j = i+1; j < arr.length; j++) {
                if(less(arr[j], arr[min])) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    @Override
    public String toString() {
        return "Selection Sort";
    }
}