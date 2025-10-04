#include <stdio.h>

void selectionSort(int arr[], int n){
    int i , j , temp;

    for (i = 0; i<n-1; i++) {

        for( j = i+1; j<n; j++){

            if (arr[j] < arr[i]) {

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

void printArray(int arr[], int n){

    for (int i = 0; i< n; i++){
        printf("%d", arr[i]);

    }
    printf("\n");
}

int main() {
    int arr[] = { 29,10,14,1,37,13};

    int n = sixeof(arr)/ sixeof(arr[0]);

    printf("Oiginal array: \n");
    printArray(arr, n);

    selectionSort(arr, n);
    printf("Sorted arrray (increasing order):\n");
    printArray(arr, n);

    return 0;
}