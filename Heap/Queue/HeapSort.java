package Heap.Queue;

import java.util.Arrays;

public class HeapSort {
    
    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 5, 50, 40};
        int len = arr.length;
        //If array is sorted using max-heap then it gives sorted order in ASC Order
        //But if array is sorted using min-heap then it gives sorted order in DSC Order
        //So, using min-heap ---> we have to reverse the result of the order.
        for(int index = len / 2 - 1; index >= 0; index--)
            heapify(arr, len, index);

        for(int index = len - 1; index >= 0; index--){
            int temp = arr[0];
            arr[0] = arr[index];
            arr[index] = temp;
        
            heapify(arr, index, 0); //max-heap
        }
        //TC: O(NLogN) SC: O(Log N) -> Recursive Stack Space
        System.out.println(Arrays.toString(arr));
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

