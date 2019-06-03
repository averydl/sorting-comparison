import java.util.PriorityQueue;

public class HeapSort implements Sort {
    private Comparable[] arr;
    public HeapSort(Comparable[] arr) {
        this.arr = arr;
    }
    /*
     * implements sort using
     * heapsort algorithm
     */
    @Override
    public void sort() {
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

    @Override
    public String toString() {
        return "Heap Sort";
    }
}