public class MergeSort implements Sort {
    private Comparable[] arr;
    public MergeSort(Comparable[] arr) {
        this.arr = arr;
    }
    /*
     * implements the sort method using
     * the merge sort algorithm
     */
    @Override
    public void sort() {
        mergeSort(arr, 0, arr.length-1);
    }

    public void mergeSort(Comparable[] arr, int first, int last) {
        if(first < last) {
            int mid = (first + last)/2;
            mergeSort(arr, first, mid);
            mergeSort(arr, mid+1, last);
            merge(arr, first, mid, last);
        }
    }

    /*
     * private helper function to merge two sorted sub-arrays
     * during execution of the mergeSort function
     */
    private void merge(Comparable[] arr, int first, int mid, int last) {
        Comparable[] temp = new Comparable[arr.length];
        int first1 = first;
        int last1 = mid;
        int first2 = mid + 1;
        int last2 = last;
        int index = first1;

        while(first1 <= last1 && first2 <= last2) {
            if(less(arr[first1], arr[first2])) {
                temp[index] = arr[first1];
                first1++;
            } else {
                temp[index] = arr[first2];
                first2++;
            }
            index++;
        }

        while(first1 <= last1) {
            temp[index] = arr[first1];
            first1++;
            index++;
        }

        while(first2 <= last2) {
            temp[index] = arr[first2];
            first2++;
            index++;
        }

        for(int i = first; i <= last; i++) {
            arr[i] = temp[i];
        }
    }

    @Override
    public String toString() {
        return "Merge Sort";
    }
}