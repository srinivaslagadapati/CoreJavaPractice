package com.lsr.problems;

public class sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {3,5,25,6,86,23,45,66};
		//System.out.println(bubbleSort(arr));
		
		System.out.println(insertionSort(arr));

	}
	
	// ===== Sorting =====
    // Bubble Sort
	/*
	 * Compare adjacent elements and swap if they are in the wrong order.	
	Keep iterating until no swaps are needed.	
	It's simple but slow.
	*/
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    // Selection Sort
    /*
     * Find the minimum element in the unsorted part and put it at the beginning.
     * Repeats until array is sorted.
     */
    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    //Build the sorted array one element at a time by inserting elements into their correct position.
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            System.out.println("/n key "+ key);
            int j = i - 1;
            System.out.println("j is "+ j+ " arr[j] "+ arr[j]);

            while (j >= 0 && arr[j] > key) {
                System.out.println("arr[j + 1] "+ arr[j]);

                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.println("arr[] "+ arr[j + 1]);

        }
        return arr;
    }

    // Merge Sort
    /*Divide array into halves recursively, sort each half, and merge back.
	Always O(n log n).
	Good for large datasets, stable sorting.*/
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort
    /*
     * Pick a pivot element, partition the array so elements < pivot go left and > pivot go right, then recursively sort parts.
		In-place and very fast in practice.
     */
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Heap Sort
    public void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
	
	

}
