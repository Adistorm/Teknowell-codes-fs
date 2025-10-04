public class quicksort {

    // Function to perform Quick Sort
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before pivot
            quickSort(arr, low, pivotIndex - 1);

            // Recursively sort elements after pivot
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    // Partition function to place pivot at correct position
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1;       // Index of smaller element

        // Compare each element with pivot
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1; // Return pivot index
    }
    // Utility function to print array
    static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
    // Driver code
    public static void main(String[] args) {
        int[] arr = {10, 54, 7, 56, 23, 8};
        System.out.println("Original Array:");
        printArray(arr);
        // Call quickSort on full array
        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
 
    
