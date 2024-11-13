package DSA.Sorting;

public class HeapSort {

    void sort(int[] arr) {

        int N = arr.length;
        // Create heap from array
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // Sort the array, but traversing one by one
        for (int i = N - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }

    }

    void heapify(int[] arr, int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && arr[l] > arr[largest])
            largest = l;

        if (r < N && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, N, largest);
        }
    }

    static void printArray(int[] arr) {
        int N = arr.length;

        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        HeapSort sort = new HeapSort();
        sort.sort(arr);

        printArray(arr);
    }
}
