package Heap.Queue;

public class maxHeapImplementation {
    
    public static void main(String[] args) {
        MaxHeap m = new MaxHeap(15);
        m.insert(5);
        m.insert(3);
        m.insert(17);
        m.insert(10);
        m.insert(84);
        m.insert(19);
        m.insert(6);
        m.insert(22);
        m.insert(9);
        m.deleteElement(0);
  
        // Print and display the maximum value in heap
        System.out.println(m.extractMaxElement());
    }
}
class MaxHeap {

    static int[] heap;
    static int size, capacity;
    MaxHeap(int cap) {
        heap = new int[cap];
        size = 0;
        capacity = cap;
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
    public static void swap(int[] arr, int i, int smallest){
        int temp = arr[i];
        arr[i] = arr[smallest];
        arr[smallest] = temp;
    }
    // Implement the function to remove maximum element.
    public static int extractMaxElement() {
        if(size == 0) return -1;
        int maxElement = heap[0]    ;
        swap(heap, 0, size-1);
        size--;
        heapify(heap, size, 0);
        return maxElement;
    }

    // Implement the function to delete an element.
    public static void deleteElement(int ind) {
        if(ind >= size) return ;
        swap(heap, ind, size-1);
        size--;
        heapify(heap, size, 0);
    }

    // Implement the function to insert 'val' in the heap.
    public static void insert(int val) {
        if(size == capacity) return ;

        heap[size++] = val;
        int indx = size - 1;

        while(indx >= 0){
            int parent = (indx - 1) / 2;
            if(heap[parent] < heap[indx]){
                swap(heap, indx, parent);
                indx = parent;
            }
            else    
                break;
        }
    }
}
