package Heap.Queue;

public class minHeapImplementation {
    
    public static void main(String[] args) {
        MinHeap m = new MinHeap(3);
        m.insert(2);
        m.insert(1);
        // m.insert(15);
        // m.deleteElement(2);
        System.out.println(m.extractMinElement());
    }
}

     class MinHeap {

        static int[] heap;
        static int size, capacity;
        MinHeap(int cap) {
            heap = new int[cap];
            size = 0;
            capacity = cap;
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
        // Implement the function to remove minimum element.
        public static int extractMinElement() {
            if(size == 0) return -1;
            int minElement = heap[0]    ;
            swap(heap, 0, size-1);
            size--;
            heapify(heap, size, 0);
            return minElement;
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
                if(heap[parent] > heap[indx]){
                    swap(heap, indx, parent);
                    indx = parent;
                }
                else    
                    break;
            }
        }
    }

