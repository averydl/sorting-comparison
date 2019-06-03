public class ShellSort implements Sort {
    private Comparable[] arr;
    public ShellSort(Comparable[] arr) {
        this.arr = arr;
    }
    /*
     * implements sort using
     * shellsort algorithm w/ a gap size
     * which reduces by a factor of 0.5 per iteration
     */
    @Override
    public void sort() {
        int gap = arr.length;
        while(gap >= 1) { // perform generalized bubbleSort with gap (reduced by factor of 2 each time) until sorted
            gap /= 2;
            for(int i = 0; i < arr.length - gap; i++) {
                if(arr[i].compareTo(arr[i+gap]) > 0) {
                    swap(arr, i, i+gap);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Shell Sort";
    }
}