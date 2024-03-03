package Heap.Queue;

import java.util.Arrays;

public class buildMaxHeap {
    
    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 5, 50, 40};
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void buildHeap(int[] arr){
        int len = arr.length;
        for(int index = len / 2 - 1; index >= 0; index--)
            heapify(arr, len, index);
    }
    public static void heapify(int[] arr, int n, int curr){
        int largest = curr;
        int left = 2 * largest + 1;
        int right = 2 * largest + 2;

        if(left < n && arr[left] > arr[largest]) largest = left;
        if(right < n && arr[right] > arr[largest]) largest = right;
        if(largest != curr){
            swap(arr, curr, largest);
            heapify(arr, n, largest);
        }
    }
    public static void swap(int[] arr, int i, int largest){
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }
}
