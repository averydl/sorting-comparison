import java.util.PriorityQueue;

public class Sort {
    public static void selectionSort(Comparable[] arr) {
        int min;
        for(int i = 0; i < arr.length; i++) {
            min = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static void insertionSort(Comparable[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0 && less(arr[j], arr[j-1]); j--) {
                  swap(arr, j, j-1);
            }
        }
    }

    public static void bubbleSort(Comparable[] arr) {
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

    public static void shellSort(Comparable[] arr) {
        int gap = arr.length;
        while(gap > 1) { // perform generalized bubbleSort with gap (reduced by factor of 2 each time) until sorted
            gap /= 2;
            for(int i = 0; i < arr.length - gap; i++) {
                if(arr[i].compareTo(arr[i+gap]) > 0) {
                    swap(arr, i, i+gap);
                }
            }
        }
        bubbleSort(arr);
    }

    public static void mergeSort(Comparable[] arr, int first, int last) {
        if(first != last) {
            int mid = (first + last)/2;
            mergeSort(arr, first, mid);
            mergeSort(arr, mid+1, last);
            merge(arr, first, last, mid);
        }
    }

    public static void heapSort(Comparable[] arr) {
        PriorityQueue<Comparable> heap = new PriorityQueue<Comparable>();

        // insert elements into priority queue (binary MIN heap)
        for(int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        // re-insert elements into array in sorted order
        for(int i = 0; i < arr.length && !heap.isEmpty(); i++) {
            arr[i] = heap.poll();
        }
    }

    public static void quickSort(Comparable[] arr, int first, int last) {
        if(last <= first) {
            return;
        }
        int pivot = partition(arr, first, last);
        quickSort(arr, first, pivot-1);
        quickSort(arr, pivot+1, last);
    }

    private static int partition(Comparable[] a, int first, int last) {
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

    private static void choosePivot(Comparable[] arr, int first, int last) {
        int pivot = (first + last) / 2;
        swap(arr, first, pivot);
    }

    private static void merge(Comparable[] arr, int first, int mid, int last) {
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

    private static void swap(Comparable[] arr, int i1, int i2) {
        Comparable swap = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = swap;
    }

    private static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

}
