public class SortContext {
    private Sort sortType;
    public SortContext(Sort sortType) {
        this.sortType = sortType;
    }

    public SortContext(String sortType, Comparable[] arr) {
        switch(sortType) {
            case("Selection Sort"):
                this.sortType = new SelectionSort(arr);
                break;
            case("Insertion Sort"):
                this.sortType = new InsertionSort(arr);
                break;
            case("Bubble Sort"):
                this.sortType = new BubbleSort(arr);
                break;
            case("Shell Sort"):
                this.sortType = new ShellSort(arr);
                break;
            case("Merge Sort"):
                this.sortType = new MergeSort(arr);
                break;
            case("Quick Sort"):
                this.sortType = new QuickSort(arr);
                break;
            default: // HeapSort
                this.sortType = new HeapSort(arr);
        }
    }

    public void executeSort() {
        sortType.sort();
    }
}