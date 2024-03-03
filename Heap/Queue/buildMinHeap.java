package Heap.Queue;

import java.util.Arrays;

public class buildMinHeap {
    
    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 5, 50, 40};
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void buildHeap(int[] arr){
        int len = arr.length;
        for(int index = len / 2 - 1; index >= 0; index--)
            heapify(arr, len, index);//min-heap
    }
    public static void heapify(int[] arr, int n, int curr){
        int smallest = curr;
        int left = 2 * smallest + 1;
        int right = 2 * smallest + 2;

        if(left < n && arr[left] < arr[smallest]) smallest = left;
        if(right < n && arr[right] < arr[smallest]) smallest = right;
        if(smallest != curr){
            swap(arr, curr, smallest);
            heapify(arr, n, smallest);
        }
    }
    public static void swap(int[] arr, int i, int smallest){
        int temp = arr[i];
        arr[i] = arr[smallest];
        arr[smallest] = temp;
    }
}
