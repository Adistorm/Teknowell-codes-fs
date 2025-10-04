#include <stdio.h>

// Function to sort the array using selection sort
void selectionSort(int arr[], int n) {
    int i, j, temp;

    for (i = 0; i < n - 1; i++) {
        // Assume the current element is the minimum
        for (j = i + 1; j < n; j++) {
            // If a smaller element is found, swap it
            if (arr[j] < arr[i]) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

// Function to print the array
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

// Main function
int main() {
    int arr[] = {29, 10, 14, 37, 13};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Original array:\n");
    printArray(arr, n);

    selectionSort(arr, n);

    printf("Sorted array (increasing order):\n");
    printArray(arr, n);

    return 0;
}
